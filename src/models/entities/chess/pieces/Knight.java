package models.entities.chess.pieces;

import models.entities.chess.ChessPiece;
import models.entities.boardgame.Board;
import models.entities.boardgame.Position;
import models.enums.Color;

public class Knight extends ChessPiece {
    private static final String ID = "N";

    public Knight() {}

    public Knight(Color color, Board board) {
        super(color, board);
    }

    public String getId() {
        return ID;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] pMoves = new boolean[this.getBoard().getRows()][this.getBoard().getRows()];

        Position pos = new Position();

        // Top right
        pos.setValues(this.position.getRow() - 2, this.position.getColumn() + 1);

        if(this.getBoard().doesThePositionExist(pos)) {
            if(!this.getBoard().isThereAPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            } else if(this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Top left
        pos.setValues(this.position.getRow() - 2, this.position.getColumn() - 1);

        if(this.getBoard().doesThePositionExist(pos)) {
            if(!this.getBoard().isThereAPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            } else if(this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Right top
        pos.setValues(this.position.getRow() - 1, this.position.getColumn() + 2);

        if(this.getBoard().doesThePositionExist(pos)) {
            if(!this.getBoard().isThereAPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            } else if(this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Right bottom
        pos.setValues(this.position.getRow() + 1, this.position.getColumn() + 2);

        if(this.getBoard().doesThePositionExist(pos)) {
            if(!this.getBoard().isThereAPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            } else if(this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Left top
        pos.setValues(this.position.getRow() - 1, this.position.getColumn() - 2);

        if(this.getBoard().doesThePositionExist(pos)) {
            if(!this.getBoard().isThereAPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            } else if(this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Left bottom
        pos.setValues(this.position.getRow() + 1, this.position.getColumn() - 2);

        if(this.getBoard().doesThePositionExist(pos)) {
            if(!this.getBoard().isThereAPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            } else if(this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Bottom left
        pos.setValues(this.position.getRow() + 2, this.position.getColumn() - 1);

        if(this.getBoard().doesThePositionExist(pos)) {
            if(!this.getBoard().isThereAPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            } else if(this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        // Bottom right
        pos.setValues(this.position.getRow() + 2, this.position.getColumn() + 1);

        if(this.getBoard().doesThePositionExist(pos)) {
            if(!this.getBoard().isThereAPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            } else if(this.isThereOpponentPiece(pos)) {
                pMoves[pos.getRow()][pos.getColumn()] = true;
            }
        }

        return pMoves;
    }

    @Override
    public String toString() {
        return ID;
    }
}
