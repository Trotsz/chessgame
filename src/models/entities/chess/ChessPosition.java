package models.entities.chess;

import models.exceptions.ChessException;
import models.entities.boardgame.Position;

public class ChessPosition {
    private int row;
    private char column;

    public ChessPosition() {}

    public ChessPosition(char column, int row) {
        if(this.isOutOfBounds(row, column)) throw new ChessException("Error with the position. Min: a1, Max: h8");

        this.row = row;
        this.column = column;
    }

    public int getRow() { return this.row; }

    public char getColumn() { return this.column; }

    protected Position toPosition() {
        int formattedRow = 8 - this.row;
        int formattedColumn = this.column - 'a';

        return new Position(formattedRow, formattedColumn);
    }

    protected static ChessPosition fromPosition(Position position) {
        int formattedRow = 8 - position.getRow();
        char formattedColumn = (char) ('a' + position.getColumn());

        return new ChessPosition(formattedColumn, formattedRow);
    }

    private boolean isOutOfBounds(int row, char column) {
        return row < 0 || row > 8 || column < 'a' || column > 'h';
    }

    @Override
    public String toString() {
        return String.valueOf(this.column).toUpperCase() + this.row; // Chess order
    }
}
