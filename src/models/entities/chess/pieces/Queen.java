package models.entities.chess.pieces;

import models.entities.boardgame.Position;
import models.entities.chess.ChessPiece;
import models.entities.boardgame.Board;
import models.enums.Color;

public class Queen extends ChessPiece {
    private static final String ID = "Q";

    public Queen() {}

    public Queen(Color color, Board board) {
        super(color, board);
    }

    public String getId() {
        return ID;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] pMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position pos = new Position();

        // FIXME: It actually works, now I just have to check the class before commiting and pushing it

        // Right
        pos.setValues(this.position.getRow(), this.position.getColumn() + 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setColumn(pos.getColumn() + 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // Left
        pos.setValues(this.position.getRow(), this.position.getColumn() - 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setColumn(pos.getColumn() - 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // Down
        pos.setValues(this.position.getRow() + 1, this.position.getColumn());

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setRow(pos.getRow() + 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // Up
        pos.setValues(this.position.getRow() - 1, this.position.getColumn());

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setRow(pos.getRow() - 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // Top right
        pos.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setValues(pos.getRow() - 1, pos.getColumn() + 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // Top left
        pos.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setValues(pos.getRow() - 1, pos.getColumn() - 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // Bottom right
        pos.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setValues(pos.getRow() + 1, pos.getColumn() + 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // Bottom left
        pos.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setValues(pos.getRow() + 1, pos.getColumn() - 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        return pMoves;
    }

    @Override
    public String toString() {
        return ID;
    }
}
