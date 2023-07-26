package models.entities.boardgame;

import models.enums.Color;

public abstract class Piece {
    protected Position position;
    private Board board;
    private Color color;

    public Piece() {}

    public Piece(Color color, Board board) {
        this.color = color;
        this.board = board;
        this.position = null;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    protected Board getBoard() {
        return this.board;
    }

    public Position getPosition() {
        return this.position;
    }

    public Color getColor() {
        return this.color;
    }

    public abstract void move();
    public abstract Position possibleMoves();
    public abstract Boolean isThereAnyPossibleMove();
}
