package models.entities.boardgame;

public class Position {
    private Integer row;
    private Integer column;

    public Position() {}

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "(" + this.row + ", " + this.column + ")";
    }
}
