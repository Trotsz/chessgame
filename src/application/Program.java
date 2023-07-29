package application;

import models.entities.boardgame.*;
import models.entities.chess.*;
import models.exceptions.BoardException;

public class Program {
    public static void main(String[] args) {
        try {
            ChessMatch cm = new ChessMatch();

            UI.printBoard(cm.getPieces());
        } catch(BoardException e) {
            System.out.println(e.getMessage());
        }
    }
}
