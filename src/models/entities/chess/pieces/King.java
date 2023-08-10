package models.entities.chess.pieces;

import models.entities.boardgame.Piece;
import models.entities.chess.ChessPiece;
import models.entities.boardgame.Position;
import models.enums.Color;
import models.entities.boardgame.Board;

public final class King extends ChessPiece {
    private static final String ID = "K";

    public King() {}

    public King(Color color, Board board) {
        super(color, board);
    }

    public String getId() {
        return ID;
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

        return pMoves;
    }

    @Override
    public String toString() {
        return ID;
    }
}
