package models.entities.chess.pieces;

import models.entities.boardgame.Board;
import models.entities.boardgame.Position;
import models.entities.chess.ChessMatch;
import models.entities.chess.ChessPiece;
import models.entities.chess.ChessPosition;
import models.enums.Color;

public class Pawn extends ChessPiece {
    private static final String ID = "P";
    private ChessMatch chessMatch;

    public Pawn() {}

    public Pawn(Color color, Board board, ChessMatch chessMatch) {
        super(color, board);
        this.chessMatch = chessMatch;
    }

    public String getId() {
        return ID;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] pMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position pos = new Position();

        if(this.getColor() == Color.WHITE) {
            pos.setValues(this.position.getRow() - 1, this.position.getColumn());

            if(this.getBoard().doesThePositionExist(pos)) {
                if (!this.getBoard().isThereAPiece(pos)) {
                    pMoves[pos.getRow()][pos.getColumn()] = true;
                }
            }

            if(this.getMoveCount() == 0 && this.position.getRow() == this.getBoard().getRows() - 2) {
                pos.setRow(this.position.getRow() - 2);

                if(this.getBoard().doesThePositionExist(pos)) {
                    Position pos2 = new Position(this.position.getRow() - 1, this.position.getColumn());
                    if (!this.getBoard().isThereAPiece(pos) && !this.getBoard().isThereAPiece(pos2)) {
                        pMoves[pos.getRow()][pos.getColumn()] = true;
                    }
                }
            }

            // Top left

            pos.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);

            if(this.getBoard().doesThePositionExist(pos)) {
                if (this.isThereOpponentPiece(pos)) {
                    pMoves[pos.getRow()][pos.getColumn()] = true;
                }
            }

            // Top right

            pos.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);

            if(this.getBoard().doesThePositionExist(pos)) {
                if (this.isThereOpponentPiece(pos)) {
                    pMoves[pos.getRow()][pos.getColumn()] = true;
                }
            }

            if(this.position.getRow() == 3) {
                if(chessMatch.getEnPassantVulnerable() != null && this.getBoard().piece(this.position.getRow(), this.position.getColumn() - 1) == chessMatch.getEnPassantVulnerable()) {
                    Position posOpponentPawn = new Position(this.position.getRow(), this.position.getColumn() - 1);

                    pMoves[posOpponentPawn.getRow() - 1][posOpponentPawn.getColumn()] = true;
                }

                if(chessMatch.getEnPassantVulnerable() != null && this.getBoard().piece(this.position.getRow(), this.position.getColumn() + 1) == chessMatch.getEnPassantVulnerable()) {
                    Position posOpponentPawn = new Position(this.position.getRow(), this.position.getColumn() + 1);

                    pMoves[posOpponentPawn.getRow() - 1][posOpponentPawn.getColumn()] = true;
                }
            }
        } else {
            pos.setValues(this.position.getRow() + 1, this.position.getColumn());

            if(this.getBoard().doesThePositionExist(pos)) {
                if (!this.getBoard().isThereAPiece(pos)) {
                    pMoves[pos.getRow()][pos.getColumn()] = true;
                }
            }

            if(this.getMoveCount() == 0 && this.position.getRow() == 1) {
                pos.setRow(this.position.getRow() + 2);

                if(this.getBoard().doesThePositionExist(pos)) {
                    Position pos2 = new Position(this.position.getRow() + 1, this.position.getColumn());

                    if (!this.getBoard().isThereAPiece(pos) && !this.getBoard().isThereAPiece(pos2)) {
                        pMoves[pos.getRow()][pos.getColumn()] = true;
                    }
                }
            }

            // Bottom left

            pos.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);

            if(this.getBoard().doesThePositionExist(pos)) {
                if (this.isThereOpponentPiece(pos)) {
                    pMoves[pos.getRow()][pos.getColumn()] = true;
                }
            }

            // Bottom right

            pos.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);

            if(this.getBoard().doesThePositionExist(pos)) {
                if (this.isThereOpponentPiece(pos)) {
                    pMoves[pos.getRow()][pos.getColumn()] = true;
                }
            }

            if(this.position.getRow() == 4) {
                if(chessMatch.getEnPassantVulnerable() != null && this.getBoard().piece(this.position.getRow(), this.position.getColumn() + 1) == chessMatch.getEnPassantVulnerable()) {
                    Position posOpponentPawn = new Position(this.position.getRow(), this.position.getColumn() + 1);

                    pMoves[posOpponentPawn.getRow() + 1][posOpponentPawn.getColumn()] = true;
                }

                if(chessMatch.getEnPassantVulnerable() != null && this.getBoard().piece(this.position.getRow(), this.position.getColumn() - 1) == chessMatch.getEnPassantVulnerable()) {
                    Position posOpponentPawn = new Position(this.position.getRow(), this.position.getColumn() - 1);

                    pMoves[posOpponentPawn.getRow() + 1][posOpponentPawn.getColumn()] = true;
                }
            }
        }

        return pMoves;
    }

    @Override
    public String toString() {
        return ID;
    }
}
