package models.entities.chess;

import models.entities.boardgame.*;
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

    protected boolean isThereOpponentPiece(Position position) {
        if(!this.getBoard().isThereAPiece(position)) return false;

        return ((ChessPiece) this.getBoard().piece(position)).getColor() != this.color;
    }
}
