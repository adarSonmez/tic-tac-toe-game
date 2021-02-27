public class Game {
    private final boolean gameOver;
    private int player;

    Game() {
        player = 0;
        gameOver = false;
    }

    // Detect if the game is over
    public boolean isGameOver(String[][] arr, int size) {
        int emptyBoxes = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
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

    // How to win
    public void determineTheWinner(String[][] arr) {
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
            if (arr[row][0].equals(arr[row][1]) && arr[row][0].equals(arr[row][2]) && !arr[row][0].equals(" ") && !isGameOver) {
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

    public void setPlayer() {
        player++;
    }

    public int getPlayer() {
        return player;
    }

    public boolean getGameOver() {
        return gameOver;
    }
}
