package models.entities.chess;

import models.entities.boardgame.*;
import models.entities.chess.pieces.*;
import models.enums.Color;
import models.exceptions.ChessException;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
        this.initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];

        for(int i = 0; i < board.getRows(); i++) {
            for(int j = 0; j < board.getColumns(); j++) {
                matrix[i][j] = (ChessPiece) this.board.piece(i, j); // Downcasting
            }
        }

        return matrix;
    }

    private void placeNewPiece(char column, int row, Piece piece) {
        this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position sourceP = sourcePosition.toPosition();
        Position targetP = targetPosition.toPosition();

        this.validateSourcePosition(sourceP);
        this.validateTargetPosition(sourceP, targetP);

        Piece capturedPiece = this.makeMove(sourceP, targetP);

        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position sourceP, Position targetP) {
        Piece capturedPiece = this.board.removePiece(targetP);

        this.board.placePiece(this.board.piece(sourceP), targetP);
        this.board.removePiece(sourceP);

        return capturedPiece;
    }

    private void validateSourcePosition(Position sourceP) {
        if(!this.board.isThereAPiece(sourceP)) throw new ChessException("There is no piece to be moved in the source position.");
        if(!this.board.piece(sourceP).isThereAnyPossibleMove()) throw new ChessException("That piece doesn't have any possible move.");
    }

    private void validateTargetPosition(Position sourceP, Position targetP) {
        Piece p = this.board.piece(sourceP);
        if(!p.possibleMove(targetP)) {
            throw new ChessException("The piece " + p + " cannot be moved to the position " + targetP);
        }
    }

    private void initialSetup() {
        this.placeNewPiece('c', 1, new Rook(Color.WHITE, this.board));
        this.placeNewPiece('c', 2, new Rook(Color.WHITE, this.board));
        this.placeNewPiece('d', 2, new Rook(Color.WHITE, this.board));
        this.placeNewPiece('e', 2, new Rook(Color.WHITE, this.board));
        this.placeNewPiece('e', 1, new Rook(Color.WHITE, this.board));
        this.placeNewPiece('d', 1, new King(Color.WHITE, this.board));

        this.placeNewPiece('c', 7, new Rook(Color.BLACK, this.board));
        this.placeNewPiece('c', 8, new Rook(Color.BLACK, this.board));
        this.placeNewPiece('d', 7, new Rook(Color.BLACK, this.board));
        this.placeNewPiece('e', 7, new Rook(Color.BLACK, this.board));
        this.placeNewPiece('e', 8, new Rook(Color.BLACK, this.board));
        this.placeNewPiece('d', 8, new King(Color.BLACK, this.board));
    }
}
