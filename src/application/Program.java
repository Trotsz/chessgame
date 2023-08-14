package application;

import models.entities.chess.*;
import models.exceptions.BoardException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ChessMatch cm = new ChessMatch();

        List<ChessPiece> capturedPieces = new ArrayList<>();

        while(!cm.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(cm, capturedPieces);

                System.out.print("Piece to move: ");
                ChessPosition sourcePosition = UI.readChessPosition(sc);

                UI.printBoard(cm.getPieces(), cm.possibleMoves(sourcePosition));

                System.out.print("Target position: ");
                ChessPosition targetPosition = UI.readChessPosition(sc);

                ChessPiece capturedPiece = cm.performChessMove(sourcePosition, targetPosition);
                if(capturedPiece != null) {
                    capturedPieces.add(capturedPiece);
                }
                if(cm.getPromoted() != null) {
                    char id;
                    do {
                        System.out.println("Inserted the piece you want the Pawn to become (Q|R|N|B):");
                        id = sc.nextLine().toUpperCase().charAt(0);
                    } while (id != 'Q' && id != 'N' && id != 'B' && id != 'R');

                    cm.replacePromotedPiece(id);
                }
            } catch(BoardException e) {
                System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
            } catch(InputMismatchException e) {
                System.out.println("\u001B[31mInput Error: " + e.getMessage() + "\u001B[0m");
            } catch(Exception e) {
                System.out.println("\u001B[31mUnexpected error: " + e.getMessage() + "\u001B[0m");
            }
        }

        UI.clearScreen();
        UI.printMatch(cm, capturedPieces);
    }
}
