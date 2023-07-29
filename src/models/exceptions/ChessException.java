package models.exceptions;

public class ChessException extends RuntimeException {
    public ChessException() {
        super("There was an error with the Chess core");
    }

    public ChessException(String message) {
        super(message);
    }
}
