package application;

import models.entities.boardgame.*;
import models.entities.chess.*;
import models.exceptions.BoardException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch cm = new ChessMatch();

        try {
            while(true) {
                UI.clearScreen();
                UI.printBoard(cm.getPieces());

                System.out.print("Piece to move: ");
                ChessPosition sourcePosition = UI.readChessPosition(sc);

                System.out.print("Target position: ");
                ChessPosition targetPosition = UI.readChessPosition(sc);

                ChessPiece capturedPiece = cm.performChessMove(sourcePosition, targetPosition);
            }
        } catch(BoardException e) {
            System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
        } catch(InputMismatchException e) {
            System.out.println("\u001B[31mInput Error: " + e.getMessage() + "\u001B[0m");
        }
    }
}
