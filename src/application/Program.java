package application;

import models.entities.boardgame.*;
import models.entities.chess.ChessMatch;
import models.entities.chess.ChessPiece;
import models.entities.chess.UI;

public class Program {
    public static void main(String[] args) {
        ChessMatch cm = new ChessMatch();

        UI.printBoard(cm.getPieces());
    }
}
