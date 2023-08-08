package models.entities.chess;

import models.entities.boardgame.*;
import models.entities.chess.pieces.*;
import models.enums.Color;
import models.exceptions.ChessException;

import java.util.List;
import java.util.ArrayList;

public class ChessMatch {
    private final Board board;
    private Integer turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;

    private List<Piece> piecesOnTheBoard;
    private List<Piece> capturedPieces;

    public ChessMatch() {
        this.board = new Board(8, 8);
        this.turn = 1;
        this.currentPlayer = Color.WHITE;
        this.piecesOnTheBoard = new ArrayList<>();
        this.capturedPieces = new ArrayList<>();
        this.initialSetup();
    }

    public int getTurn() {
        return this.turn;
    }

    public Color getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean getCheck() {
        return this.check;
    }

    public boolean getCheckMate() {
        return this.checkMate;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setCurrentPlayer(Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] matrix = new ChessPiece[this.board.getRows()][this.board.getColumns()];

        for(int i = 0; i < this.board.getRows(); i++) {
            for(int j = 0; j < this.board.getColumns(); j++) {
                matrix[i][j] = (ChessPiece) this.board.piece(i, j); // Downcasting
            }
        }

        return matrix;
    }

    private void nextTurn() {
        this.turn += 1;
        this.currentPlayer = this.currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position sourceP = sourcePosition.toPosition();
        Position targetP = targetPosition.toPosition();

        this.validateSourcePosition(sourceP);
        this.validateTargetPosition(sourceP, targetP);

        ChessPiece capturedPiece = (ChessPiece) this.makeMove(sourceP, targetP);

        if(this.checkTest(this.currentPlayer)) {
            this.undoMove(sourceP, targetP, capturedPiece);
            throw new ChessException("You cannot move that " + this.board.piece(sourceP) + " piece, because your King will be in check.");
        }

        this.check = this.checkTest(this.opponent(this.currentPlayer));
        this.checkMate = this.checkMateTest(this.opponent(this.currentPlayer));

        if(!checkMate) {
            this.nextTurn();
        }

        return capturedPiece;
    }

    private Piece makeMove(Position sourceP, Position targetP) {
        Piece capturedPiece = this.board.removePiece(targetP);
        Piece p = this.board.piece(sourceP);

        this.board.removePiece(sourceP);
        this.board.placePiece(p, targetP);

        if(capturedPiece != null) {
            this.capturedPieces.add(capturedPiece);
            this.piecesOnTheBoard.remove(capturedPiece);
        }

        return capturedPiece;
    }

    private void validateSourcePosition(Position sourceP) {
        if(!this.board.isThereAPiece(sourceP)) throw new ChessException("There is no piece to be moved in the source position.");
        if(((ChessPiece) this.board.piece(sourceP)).getColor() != this.currentPlayer) throw new ChessException("That piece is not yours.");
        if(!this.board.piece(sourceP).isThereAnyPossibleMove()) throw new ChessException("That piece doesn't have any possible move.");
    }

    private void validateTargetPosition(Position sourceP, Position targetP) {
        Piece p = this.board.piece(sourceP);
        if(!p.possibleMove(targetP)) {
            throw new ChessException("The piece " + p + " cannot be moved to the position " + targetP);
        }
    }

    private void undoMove(Position sourceP, Position targetP, ChessPiece capturedPiece) {
        Piece originalPiece = this.board.removePiece(targetP);
        this.board.placePiece(originalPiece, sourceP);
        if(capturedPiece != null) {
            this.board.placePiece(capturedPiece, targetP);
            this.capturedPieces.remove(capturedPiece);
            this.piecesOnTheBoard.add(capturedPiece);
        }
    }

    public boolean[][] possibleMoves(ChessPosition sourceP) {
        Position convertedSourceP = sourceP.toPosition();

        this.validateSourcePosition(convertedSourceP);

        boolean[][] pMoves = this.board.piece(convertedSourceP).possibleMoves();

        return pMoves;
    }

    private Color opponent(Color color) {
        return color == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece king(Color color) {
        List<Piece> l = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color).toList();
        for(Piece p : l) {
            if(p instanceof King) {
                return (ChessPiece) p;
            }
        }

        throw new IllegalStateException("The king of color " + color + " does not exist on the board.");
    }

    private boolean checkTest(Color color) {
        Position kingPosition = this.king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = this.piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == this.opponent(color)).toList();

        for(Piece p : opponentPieces) {
            if(p.isThereAnyPossibleMove()) {
                boolean[][] possibleMoves = p.possibleMoves();

                if(possibleMoves[kingPosition.getRow()][kingPosition.getColumn()]) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkMateTest(Color color) {
        if(!this.checkTest(color)) return false;
        List<Piece> l = this.piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color).toList();

        for(Piece p : l) {
            if(p.isThereAnyPossibleMove()) {
                boolean[][] pMoves = p.possibleMoves();

                for(int i = 0; i < pMoves.length; i++) {
                    for(int j = 0; j < pMoves[0].length; j++) {
                        if(pMoves[i][j]) {
                            Position sourcePosition = ((ChessPiece) p).getChessPosition().toPosition();
                            Position targetPosition = new Position(i, j);
                            Piece capturedPiece = this.makeMove(sourcePosition, targetPosition);

                            boolean checkTest = this.checkTest(color);
                            this.undoMove(sourcePosition, targetPosition, (ChessPiece) capturedPiece);

                            if(!checkTest) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
        this.piecesOnTheBoard.add(piece);
    }

    private void initialSetup() {
        this.placeNewPiece('h', 7, new Rook(Color.WHITE, this.board));
        this.placeNewPiece('d', 1, new Rook(Color.WHITE, this.board));
        this.placeNewPiece('e', 1, new King(Color.WHITE, this.board));

        this.placeNewPiece('b', 8, new Rook(Color.BLACK, this.board));
        this.placeNewPiece('a', 8, new King(Color.BLACK, this.board));

    }
}
