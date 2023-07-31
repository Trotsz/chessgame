package models.entities.boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece() {}

    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    protected Board getBoard() {
        return this.board;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean possibleMove(Position position) { // Hook method
        return this.possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() { // Hook method
        for(int i = 0; i < this.possibleMoves().length; i++) {
            for(int j = 0; j < this.possibleMoves()[0].length; j++) {
                if(this.possibleMoves()[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract boolean[][] possibleMoves();

}
