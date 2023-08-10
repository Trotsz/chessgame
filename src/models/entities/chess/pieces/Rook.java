package models.entities.chess.pieces;

import models.entities.boardgame.Board;
import models.entities.boardgame.Piece;
import models.entities.chess.ChessPiece;
import models.entities.boardgame.Position;
import models.enums.Color;

public final class Rook extends ChessPiece {
    private static final String ID = "R";

    public Rook() {}

    public Rook(Color color, Board board) {
        super(color, board);
    }

    public String getId() {
        return ID;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] pMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position pos = new Position();

        // Above

        pos.setValues(this.position.getRow() - 1, this.position.getColumn());

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setRow(pos.getRow() - 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // Left side

        pos.setValues(this.position.getRow(), this.position.getColumn() - 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setColumn(pos.getColumn() - 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // Right side

        pos.setValues(this.position.getRow(), this.position.getColumn() + 1);

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setColumn(pos.getColumn() + 1);
        }

        if(this.getBoard().doesThePositionExist(pos) && this.isThereOpponentPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // Below

        pos.setValues(this.position.getRow() + 1, this.position.getColumn());

        while(this.getBoard().doesThePositionExist(pos) && !this.getBoard().isThereAPiece(pos)) {
            pMoves[pos.getRow()][pos.getColumn()] = true;

            pos.setRow(pos.getRow() + 1);
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
