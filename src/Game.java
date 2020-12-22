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
            System.out.print("Enter a col for player " + sign + ": ");
            int col = input.nextInt();

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

            gameOver = isGameOver(matrix);
        }
    }

    // Print initial table
    public static void blankTable(String[][] arr) {
        System.out.println("-------");
        for(int r = 0; r < 3; r++) {
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
        for(int r = 0; r < 3; r++) {
            System.out.print("|");
            for (int c = 0; c < 3; c++) {
                System.out.print(arr[r][c] + "|");
                if (c == 2)
                    System.out.println();
            }
        }
        System.out.println("-------");
    }

    // Detect if the game is over
    public static boolean isGameOver(String[][] arr) {
        int emptyBoxes = 0;
        for(int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (arr[r][c].equals(" "))
                    emptyBoxes++;
            }
        }
        if (emptyBoxes == 0)
            System.out.println("Game Over...");

        return emptyBoxes == 0;
    }
}