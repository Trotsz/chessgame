package models.exceptions;

public class BoardException extends RuntimeException {
    public BoardException() {
        super("An error has occurred with the board.");
    }

    public BoardException(String message) {
         super(message);
    }
}
