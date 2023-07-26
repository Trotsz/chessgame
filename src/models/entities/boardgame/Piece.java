package models.entities.boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece() {}

    public Piece(Board board) {
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

    public abstract Piece[][] possibleMoves();
    public abstract Boolean isThereAnyPossibleMove();
}
