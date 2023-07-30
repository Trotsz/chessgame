package application;

import models.entities.boardgame.*;
import models.entities.chess.*;
import models.exceptions.BoardException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch cm = new ChessMatch();

        try {
            UI.printBoard(cm.getPieces());

            while(true) {
                System.out.print("Piece to move: ");
                ChessPosition sourcePosition = UI.readChessPosition(sc);

                System.out.print("Target position: ");
                ChessPosition targetPosition = UI.readChessPosition(sc);

                ChessPiece capturedPiece = cm.performChessMove(sourcePosition, targetPosition);

                System.out.println();
                UI.printBoard(cm.getPieces());
            }
        } catch(BoardException e) {
            System.out.println(e.getMessage());
        }
    }
}
