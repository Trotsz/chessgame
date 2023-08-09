package models.entities.chess;

import models.entities.boardgame.*;
import models.enums.Color;

public abstract class ChessPiece extends Piece {
    private Color color;
    private Integer moveCount;

    public ChessPiece() {}

    public ChessPiece(Color color, Board board) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    protected void increaseMoveCount(int amount) {
        this.moveCount += amount;
    }

    protected void decreaseMoveCount(int amount) {
        this.moveCount -= amount;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(this.position);
    }

    protected boolean isThereOpponentPiece(Position position) {
        if(!this.getBoard().isThereAPiece(position)) return false;

        return ((ChessPiece) this.getBoard().piece(position)).getColor() != this.color;
    }
}
