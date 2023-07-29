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

    private void placeNewPiece(char column, int row, Piece piece) {
        this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(Color.WHITE, this.board));
        placeNewPiece('c', 2, new Rook(Color.WHITE, this.board));
        placeNewPiece('d', 2, new Rook(Color.WHITE, this.board));
        placeNewPiece('e', 2, new Rook(Color.WHITE, this.board));
        placeNewPiece('e', 1, new Rook(Color.WHITE, this.board));
        placeNewPiece('d', 1, new King(Color.WHITE, this.board));

        placeNewPiece('c', 7, new Rook(Color.BLACK, this.board));
        placeNewPiece('c', 8, new Rook(Color.BLACK, this.board));
        placeNewPiece('d', 7, new Rook(Color.BLACK, this.board));
        placeNewPiece('e', 7, new Rook(Color.BLACK, this.board));
        placeNewPiece('e', 8, new Rook(Color.BLACK, this.board));
        placeNewPiece('d', 8, new King(Color.BLACK, this.board));
    }
}
