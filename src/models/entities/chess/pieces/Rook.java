package models.entities.chess.pieces;

import models.entities.boardgame.Board;
import models.entities.boardgame.Piece;
import models.entities.chess.ChessPiece;
import models.entities.boardgame.Position;
import models.enums.Color;

public final class Rook extends ChessPiece {
    private static final String id = "R";

    public Rook() {}

    public Rook(Color color, Board board) {
        super(color, board);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] pMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        ChessPiece p = (ChessPiece) this.getBoard().piece(0, 1);

        for(int i = 0; i < pMoves.length; i++) {
            for(int j = 0; j < pMoves[0].length; j++) {
                if(i == this.position.getRow() && !this.getBoard().isThereAPiece(new Position(i, j))) {
                    pMoves[i][j] = true;
                } else if(i == this.position.getRow() && ((ChessPiece) this.getBoard().piece(i, j)).getColor() != this.getColor()) {
                    pMoves[i][j] = true;
                }

                if(j == this.position.getColumn()) {

                }
            }
        }
    }

    @Override
    public boolean isThereAnyPossibleMove() {
        return false;
    }

    @Override
    public String toString() {
        return id;
    }
}
