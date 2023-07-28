package models.entities.chess.pieces;

import models.entities.boardgame.Board;
import models.entities.boardgame.Piece;
import models.entities.chess.ChessPiece;
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
    public Piece[][] possibleMoves() {
        return new Piece[][]{};
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
