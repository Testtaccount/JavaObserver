package book.objectorienteddesign.tictactoe.project;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Player player1 = new Player();
    static Player player2 = new Player();
    static String[][] board = new String[3][3];
    static boolean[] entered = new boolean[9];
    static boolean isFirstPlayerGame = true;

    public static void main(String[] args) {

        System.out.println("START");
        System.out.print("Please enter name for Player first 'X' : ");
        String firstName = scanner.next();
        System.out.print("Please enter name for Player second 'O' : ");
        String secondName = scanner.next();
        player1.setName(firstName);
        player2.setName(secondName);

        initBoard();
        printBoard(board);

        boolean exit = false;
        while (!exit) {
            printName(isFirstPlayerGame);
            String in = scanner.next();
            if (checkInput(in)) {
                setToBoard(in, isFirstPlayerGame);
                printBoard(board);

                if (isWin()) {
                    exit = true;
                    System.out.println("---------------------------------------------------");
                    System.out.println(isFirstPlayerGame ? "Player " + player1.getName() + " win !!!" : "Player " + player2.getName() + " win !!!");
                    System.out.println("---------------------------------------------------");
                } else if (isGameOver()) {
                    exit = true;
                    System.out.println("---------------------------------------------------");
                    System.out.println("TRY AGAIN, GAME OVER !!!");
                    System.out.println("---------------------------------------------------");
                }
                isFirstPlayerGame = !isFirstPlayerGame;
            }
        }

    }

    private static boolean isGameOver() {
        boolean ret = true;
        for (int i = 0; i < entered.length; i++) {
            if (!entered[i]) ret = false;
        }
        return ret;
    }

    private static boolean isWin() {

        return board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X") ||
                board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X") ||
                board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X") ||

                board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X") ||
                board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X") ||
                board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X") ||

                board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X") ||
                board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X") ||

                board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O") ||
                board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O") ||
                board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O") ||

                board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O") ||
                board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O") ||
                board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O") ||

                board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O") ||
                board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O");

    }

    private static void printName(boolean isPlayer1) {
        System.out.println("---------------------------------------------------");
        System.out.println(isPlayer1 ? player1.getName() + " choose number in board for 'X'" : player2.getName() + " choose number in board for 'O'");
        System.out.println("---------------------------------------------------");
    }

    private static boolean checkInput(String in) {
        if (Integer.valueOf(in) < 1 || Integer.valueOf(in) > 9) {
            System.out.println("Please enter number from 1-9 !");
            return false;
        } else if (entered[Integer.parseInt(in) - 1]) {
            System.out.println("Please enter another number from 1-9 !");
            return false;
        }
        return true;

    }

    private static void printBoard(String[][] board) {
        System.out.print("\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j != 2) System.out.print(" | ");
                else if (i == 0 || i == 1) System.out.print("\n-   -   -");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private static void setToBoard(String n, boolean isFirst) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((board[i][j]).equals(n)) {
                    if (isFirst) {
                        board[i][j] = "X";
                    } else {
                        board[i][j] = "O";
                    }
                    entered[Integer.parseInt(n) - 1] = true;
                }
            }
        }
    }

    private static void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0)
                    board[i][j] = String.valueOf(i + j + 1);
                if (i == 1)
                    board[i][j] = String.valueOf(i + j + 3);
                if (i == 2)
                    board[i][j] = String.valueOf(i + j + 5);

            }
        }
    }

    public static class Player {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

