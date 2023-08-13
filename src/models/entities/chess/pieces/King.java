package models.entities.chess.pieces;

import models.entities.chess.ChessPiece;
import models.entities.chess.ChessMatch;
import models.entities.boardgame.Piece;
import models.entities.boardgame.Position;
import models.entities.boardgame.Board;
import models.enums.Color;

public final class King extends ChessPiece {
    private static final String ID = "K";
    private ChessMatch chessMatch;

    public King() {}

    public King(Color color, Board board, ChessMatch chessMatch) {
        super(color, board);
        this.chessMatch = chessMatch;
    }

    public String getId() {
        return ID;
    }

    public boolean rookCastlingTest(Position position) {
        ChessPiece piece = (ChessPiece) this.getBoard().piece(position);

        return piece instanceof Rook && piece.getColor() == this.getColor() && piece.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] pMoves = new boolean[this.getBoard().getRows()][this.getBoard().getRows()];

        Position pos = new Position();
        Board board = this.getBoard();

        // Above

        pos.setValues(this.position.getRow() - 1, this.position.getColumn());

        if(board.doesThePositionExist(pos)) {
            if(!board.isThereAPiece(pos) || this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Left

        pos.setValues(this.position.getRow(), this.position.getColumn() - 1);

        if(board.doesThePositionExist(pos)) {
            if(!board.isThereAPiece(pos) || this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Below

        pos.setValues(this.position.getRow() + 1, this.position.getColumn());

        if(board.doesThePositionExist(pos)) {
            if(!board.isThereAPiece(pos) || this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Right

        pos.setValues(this.position.getRow(), this.position.getColumn() + 1);

        if(board.doesThePositionExist(pos)) {
            if(!board.isThereAPiece(pos) || this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Top Right

        pos.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);

        if(board.doesThePositionExist(pos)) {
            if(!board.isThereAPiece(pos) || this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Top left

        pos.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);

        if(board.doesThePositionExist(pos)) {
            if(!board.isThereAPiece(pos) || this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Bottom right

        pos.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);

        if(board.doesThePositionExist(pos)) {
            if(!board.isThereAPiece(pos) || this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Bottom left

        pos.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);

        if(board.doesThePositionExist(pos)) {
            if(!board.isThereAPiece(pos) || this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Castling verification
        if(this.getMoveCount() == 0 && !this.chessMatch.getCheck()) {
            // King side castling
            Position posKingSide = new Position(this.position.getRow(), this.position.getColumn() + 3);

            if(this.rookCastlingTest(posKingSide)) {
                Position p1 = new Position(this.position.getRow(), this.position.getColumn() + 1);
                Position p2 = new Position(this.position.getRow(), this.position.getColumn() + 2);
                if(this.getBoard().piece(p1) == null && this.getBoard().piece(p2) == null) {
                    pMoves[this.position.getRow()][this.position.getColumn() + 2] = true;
                }
            }

            // Queen side castling
            Position posQueenSide = new Position(this.position.getRow(), this.position.getColumn() - 4);

            if(this.rookCastlingTest(posQueenSide)) {
                Position p1 = new Position(this.position.getRow(), this.position.getColumn() - 1);
                Position p2 = new Position(this.position.getRow(), this.position.getColumn() - 2);
                Position p3 = new Position(this.position.getRow(), this.position.getColumn() - 3);
                if(this.getBoard().piece(p1) == null && this.getBoard().piece(p2) == null && this.getBoard().piece(p3) == null) {
                    pMoves[this.position.getRow()][this.position.getColumn() - 2] = true;
                }
            }
        }

        return pMoves;
    }

    @Override
    public String toString() {
        return ID;
    }
}
