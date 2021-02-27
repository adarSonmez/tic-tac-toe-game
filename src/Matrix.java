public class Matrix {
    final private int size = 3;
    String[][] matrix;
    boolean availability;

    Matrix() {
        matrix = new String[size][size];
        availability = true;
        blankTable(matrix);
    }

    // Print initial table
    private void blankTable(String[][] arr) {
        System.out.println("-------");
        for (int r = 0; r < this.size; r++) {
            System.out.print("|");
            for (int c = 0; c < this.size; c++) {
                String e = arr[r][c] = " ";
                System.out.print(e + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    public void printTable(String[][] arr) {
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

    // What if I enter chosen box
    public boolean isTheBoxAvailable(String[][] arr, int row, int col) {
        availability = arr[row - 1][col - 1].equals(" ");
        return availability;
    }

    // accessors
    public int getSize() {
        return size;
    }

    public String[][] getMatrix() {
        return matrix;
    }
}
