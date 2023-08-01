package models.entities.boardgame;

import models.entities.chess.ChessPiece;
import models.exceptions.BoardException;

public class Board {
    private Integer rows;
    private Integer columns;
    protected Piece[][] pieces;

    public Board() {}

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1) throw new BoardException("Error: The rows and columns cannot be lower than 1.");
        if(rows != columns) throw new BoardException("Error: The amount of rows and columns must be the same.");

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
        if(!this.doesThePositionExist(row, column)) {
            throw new BoardException("Error: The inserted position does not exist.");
        }

        return this.pieces[row][column];
    }

    public Piece piece(Position position) {
        if(!this.doesThePositionExist(position)) {
            throw new BoardException("Error: The inserted position does not exist.");
        }

        return this.pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public boolean doesThePositionExist(Position position) {
        return this.doesThePositionExist(position.getRow(), position.getColumn());
    }

    private boolean doesThePositionExist(int row, int column) {
        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }

    public boolean isThereAPiece(Position position) {
        if(!this.doesThePositionExist(position)) {
            throw new BoardException("Error: the position (" + position + ") does not exist.");
        }

        return this.piece(position) != null;
    }

    public Piece removePiece(Position position) {
        Piece p = this.piece(position);

        this.pieces[position.getRow()][position.getColumn()] = null;

        if(p != null) p.position = null;

        return p;
    }
}
