import java.util.Arrays;

public class Moves {

    public int[][] grid; //make private later
    private int rows;
    private int cols;
    private int[] OPTIONS = {2, -1, 2, 1, -2, -1, -2, 1, 1, -2, 1, 2, -1, -2, -1, 2};

    private int totalBeginning(int row, int col) { //function that determines number of moves
        int count = 0;
        for (int i = 0; i < OPTIONS.length; i += 2) {
            int newRow = row + OPTIONS[i];
            int newCol = col + OPTIONS[i + 1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                count++;
            }
        }
        return count;
    }

    public Moves(int numRows, int numCols) { //constructor makes all the moves in rows x cols board
        grid = new int[numRows][numCols];
        rows = numRows;
        cols = numCols;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = totalBeginning(i, j);
            }
        }
    }

    public boolean addK(int row, int col) { //adds the knight and updates the grid.
        if (grid[row][col] == 9) {
            return false;
        } else {
            for (int i = 0; i < OPTIONS.length; i += 2) {
                int newRow = row + OPTIONS[i];
                int newCol = col + OPTIONS[i + 1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (grid[newRow][newCol] != 9) {
                        grid[newRow][newCol]--;
                    }
                }
            }
            grid[row][col] = 9;
            return true;
        }
    }
    public static void main(String[] args) {
        Moves test = new Moves(3, 7);
        for (int i = 0; i < test.grid.length; i++) {
            System.out.println(Arrays.toString(test.grid[i]));
        }
        System.out.println();
    }
}
