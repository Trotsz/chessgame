package models.entities.chess;

import models.entities.boardgame.*;
import models.entities.chess.pieces.*;
import models.enums.Color;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
        this.initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];

        for(int i = 0; i < board.getRows(); i++) {
            for(int j = 0; j < board.getColumns(); j++) {
                matrix[i][j] = (ChessPiece) this.board.piece(i, j); // Downcasting
            }
        }

        return matrix;
    }

    private void placeNewPiece(Piece piece, char column, int row) {
        this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        this.placeNewPiece(new Rook(Color.BLACK, this.board), 'b', 6);
        this.placeNewPiece(new King(Color.BLACK, this.board), 'c', 7);
        // ongoing development
    }
}
