package models.entities.chess.pieces;

import models.entities.boardgame.Piece;
import models.entities.chess.ChessPiece;
import models.entities.boardgame.Position;
import models.enums.Color;
import models.entities.boardgame.Board;

public final class King extends ChessPiece {
    private static String id = "K";

    public King() {}

    public King(Color color, Board board) {
        super(color, board);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] pMoves = new boolean[this.getBoard().getRows()][this.getBoard().getRows()];

        return pMoves;
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
