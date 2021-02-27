import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Matrix matrix = new Matrix();
        Game game = new Game();

        int size = matrix.getSize();
        int player = game.getPlayer();
        boolean gameOver = game.getGameOver();

        while (!gameOver) {
            // This is a two player game
            String sign = player == 0 ? "X" : "O";

            System.out.print("Enter a row for player " + sign + ": ");
            int row = input.nextInt();
            while (row < 1 || row > size) {
                System.out.println("No such row found. Enter again");
                row = input.nextInt();
            }

            System.out.print("Enter a col for player " + sign + ": ");
            int col = input.nextInt();
            while (col < 1 || col > size) {
                System.out.println("No such column found. Enter again");
                col = input.nextInt();
            }

            // What if I enter chosen box
            if (!matrix.isTheBoxAvailable(matrix.getMatrix(), row, col)) {
                System.out.println("This box is not available!");
                System.out.println("Choose another box.");
                continue;
            }

            // Print user's choice
            matrix.getMatrix()[row - 1][col - 1] = sign;
            matrix.printTable(matrix.getMatrix());

            // Change the turn
            game.setPlayer();
            player = game.getPlayer() % 2;

            game.determineTheWinner(matrix.getMatrix());
            gameOver = game.isGameOver(matrix.getMatrix(), size);
        }
    }
}