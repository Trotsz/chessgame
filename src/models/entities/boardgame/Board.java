package models.entities.boardgame;

import java.util.List;
import java.util.ArrayList;
public class Board {
    private Integer rows;
    private Integer columns;
    protected Piece[][] pieces;

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

    public Piece piece(int row, int column) {
        return this.pieces[row][column];
    }

    public Piece piece(Position position) {
        return this.pieces[position.getRow()][position.getColumn()];
    }

//    public void setPieces(Piece piece, Position position) {
//        if(piece.isThereAnyPossibleMove()) {
//
//        }
//        this.pieces[position.getRow()][position.getColumn()] = piece;
//        piece.setPosition(position);
//    }
}
