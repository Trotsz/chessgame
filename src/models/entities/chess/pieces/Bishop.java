package models.entities.chess.pieces;

import models.entities.chess.ChessPiece;
import models.entities.boardgame.Position;
import models.entities.boardgame.Board;
import models.enums.Color;

public class Bishop extends ChessPiece {
    private static final String ID = "B";

    public Bishop() {}

    public Bishop(Color color, Board board) {
        super(color, board);
    }

    public String getId() {
        return ID;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] pMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position pos = new Position();

        // Northwest
        pos.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setValues(pos.getRow() - 1, pos.getColumn() - 1);
        }

        if(this.getBoard().doesThePositionExist(pos)) {
            if (this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Northeast
        pos.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setValues(pos.getRow() - 1, pos.getColumn() + 1);
        }

        if(this.getBoard().doesThePositionExist(pos)) {
            if (this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Southeast
        pos.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setValues(pos.getRow() + 1, pos.getColumn() + 1);
        }

        if(this.getBoard().doesThePositionExist(pos)) {
            if (this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Southwest

        pos.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setValues(pos.getRow() + 1, pos.getColumn() - 1);
        }

        if(this.getBoard().doesThePositionExist(pos)) {
            if (this.isThereOpponentPiece(pos)) {
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
