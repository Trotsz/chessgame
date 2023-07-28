package models.entities.chess.pieces;

import models.entities.boardgame.Piece;
import models.entities.chess.ChessPiece;
import models.entities.boardgame.Position;
import models.enums.Color;
import models.entities.boardgame.Board;

public class King extends ChessPiece {
    private static String id = "K";

    public King() {}

    public King(Color color, Board board) {
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