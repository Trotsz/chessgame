package models.entities.chess;

import models.entities.boardgame.Piece;
import models.entities.boardgame.Board;
import models.enums.Color;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece() {}

    public ChessPiece(Color color, Board board) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
