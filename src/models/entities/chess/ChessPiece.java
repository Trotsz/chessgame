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
        this.moveCount = 0;
    }

    public Color getColor() {
        return this.color;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    protected void increaseMoveCount() {
        this.moveCount += 1;
    }

    protected void decreaseMoveCount() {
        this.moveCount -= 1;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(this.position);
    }

    protected boolean isThereOpponentPiece(Position position) {
        if(!this.getBoard().isThereAPiece(position)) return false;

        return ((ChessPiece) this.getBoard().piece(position)).getColor() != this.color;
    }
}
