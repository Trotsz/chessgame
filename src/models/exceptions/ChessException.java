package models.exceptions;

public class ChessException extends BoardException {
    public ChessException() {
        super("There was an error with the Chess core");
    }

    public ChessException(String message) {
        super(message);
    }
}
