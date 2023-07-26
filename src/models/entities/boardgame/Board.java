package models.entities.boardgame;

import java.util.List;
import java.util.ArrayList;
public class Board {
    private Integer rows;
    private Integer columns;
    private Piece[][] pieces;

    public Board() {}

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

//    public void setPieces(Piece piece, Position position) {
//        this.pieces[position.getRow()][position.getColumn()] = piece;
//        piece.setPosition(position);
//    }
}
