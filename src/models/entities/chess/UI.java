package models.entities.chess;

import models.enums.Color;
import models.entities.boardgame.Position;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    public UI() {}

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();

            char column = s.charAt(0);
            int row = Integer.parseInt(String.valueOf(s.charAt(1)));

            return new ChessPosition(column, row);
        } catch(InputMismatchException e) {
            throw new InputMismatchException("Error with input values. Values: a1 - h8");
        }
    }

    public static void printBoard(ChessPiece[][] chessPieces) {
        for(int i = 0; i < chessPieces.length; i++) {
            System.out.print((8 - i) + " ");
            for(int j = 0; j < chessPieces[0].length; j++) {
                printPiece(chessPieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void printBoard(ChessPiece[][] chessPieces, boolean[][] possibleMoves) {
        for(int i = 0; i < possibleMoves.length; i++) {
            System.out.print(8 - i + " ");
            for(int j = 0; j < possibleMoves[0].length; j++) {
                printPiece(chessPieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, boolean possibleMove) {
        if(possibleMove) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if(piece == null) {
            System.out.print("-" + ANSI_RESET);
        } else {
            if(piece.getColor() == Color.BLACK) {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
        }

        System.out.print(" ");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
