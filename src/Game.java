import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Create the the game table
        String[][] matrix = new String[3][3];
        blankTable(matrix);

        Scanner input = new Scanner(System.in);
        int player = 0;
        boolean gameOver = false;

        while (!gameOver) {
            // This is a two player game
            String sign = player == 0 ? "X" : "O";

            System.out.print("Enter a row for player " + sign + ": ");
            int row = input.nextInt();
            while (row < 1 || row > 3) {
                System.out.println("No such row found. Enter again");
                row = input.nextInt();
            }

            System.out.print("Enter a col for player " + sign + ": ");
            int col = input.nextInt();
            while (col < 1 || col > 3) {
                System.out.println("No such column found. Enter again");
                col = input.nextInt();
            }

            // What if I enter chosen box
            if (!isTheBoxAvailable(matrix, row, col)) {
                System.out.println("This box is not available!");
                System.out.println("Choose another box.");
                continue;
            }

            // Print user's choice
            matrix[row - 1][col - 1] = sign;
            printTable(matrix);

            // Change the turn
            player++;
            player %= 2;

            determineTheWinner(matrix);
            gameOver = isGameOver(matrix);
        }
    }

    // Print initial table
    public static void blankTable(String[][] arr) {
        System.out.println("-------");
        for (int r = 0; r < 3; r++) {
            System.out.print("|");
            for (int c = 0; c < 3; c++) {
                String e = arr[r][c] = " ";
                System.out.print(e + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    // What if I enter chosen box
    public static boolean isTheBoxAvailable(String[][] arr, int row, int col) {
        boolean availability = true;
        if (!arr[row - 1][col - 1].equals(" ")) {
            availability = false;
        }

        return availability;
    }

    public static void printTable(String[][] arr) {
        System.out.println("-------");
        for (int r = 0; r < 3; r++) {
            System.out.print("|");
            for (int c = 0; c < 3; c++) {
                System.out.print(arr[r][c] + "|");
                if (c == 2)
                    System.out.println();
            }
        }
        System.out.println("-------");
    }

    // How to win
    public static void determineTheWinner(String[][] arr) {
        boolean isGameOver = false;
        String whoWon = "";

        // All winning combinations
        // Check columns
        for (int col = 0; col < 3; col++) {
            if (arr[0][col].equals(arr[1][col]) && arr[0][col].equals(arr[2][col]) && !(arr[0][col].equals(" "))) {
                isGameOver = true;
                whoWon = arr[0][col];
                break;
            }
        }
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (arr[row][0].equals(arr[row][1]) && arr[row][0].equals(arr[row][2]) && !arr[row][0].equals(" ")  && !isGameOver) {
                isGameOver = true;
                whoWon = arr[row][0];
                break;
            }
        }

        // Cross check
        if (arr[0][0].equals(arr[2][2]) && arr[0][0].equals(arr[1][1]) && !arr[0][0].equals(" ") && !isGameOver) {
            isGameOver = true;
            whoWon = arr[2][2];
        } else if (arr[0][2].equals(arr[1][1]) && arr[0][2].equals(arr[2][0]) && !arr[1][1].equals(" ") && !isGameOver) {
            isGameOver = true;
            whoWon = arr[1][1];
        }

        // Announce the winner and finish tha game
        if (isGameOver) {
            System.out.println("Player " + whoWon + " won the game!");
            System.exit(0);
        }
    }

    // Detect if the game is over
    public static boolean isGameOver(String[][] arr) {
        int emptyBoxes = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (arr[r][c].equals(" "))
                    emptyBoxes++;
            }
        }
        if (emptyBoxes == 0) {
            System.out.println("It's a tie.");
            System.exit(0);
        }

        return false;
    }
}