import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Moves {

    private int[][] grid;
    private int rows;
    private int cols;
    private int[] OPTIONS = {2, -1, 2, 1, -2, -1, -2, 1, 1, -2, 1, 2, -1, -2, -1, 2}; //they come in pairs, first is row inc., second is col inc.

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
        if (grid[row][col] == -1) { //-1 means the knight has been there
            return false;
        } else {
            for (int i = 0; i < OPTIONS.length; i += 2) {
                int newRow = row + OPTIONS[i];
                int newCol = col + OPTIONS[i + 1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (grid[newRow][newCol] != -1) {
                        grid[newRow][newCol]--;
                    }
                }
            }
            grid[row][col] = -1;
            return true;
        }
    }

    public boolean removeK(int row, int col) { //removes the knight and updates the grid
        if (grid[row][col] != -1) {
            return false;
        } else {
            int count = 0;
            for (int i = 0; i < OPTIONS.length; i += 2) {
                int newRow = row + OPTIONS[i];
                int newCol = col + OPTIONS[i + 1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (grid[newRow][newCol] != -1) {
                        grid[newRow][newCol]++;
                        count++;
                    }
                }
            }
            grid[row][col] = count;
            return true;
        }
    }

    public int[] bestOption(int row, int col) { //returns the optimal moves to go to
        ArrayList<Option> options = new ArrayList<Option>();
        for (int i = 0; i < OPTIONS.length; i += 2) {
            int newRow = row + OPTIONS[i];
            int newCol = col + OPTIONS[i + 1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                if (grid[newRow][newCol] != -1) {
                    options.add(new Option(OPTIONS[i], OPTIONS[i + 1], grid[newRow][newCol]));
                }
            }
        }
        Collections.sort(options);
        int[] ans = new int[options.size() * 2];
        for (int i = 0; i < options.size(); i++) {
            ans[2 * i] = options.get(i).getRowInc();
            ans[2 * i + 1] = options.get(i).getColInc();
        }
        return ans;

    }
    public static void main(String[] args) {
        Moves test = new Moves(5, 5);
        for (int i = 0; i < test.grid.length; i++) {
            System.out.println(Arrays.toString(test.grid[i]));
        }
        System.out.println();
        test.addK(0, 0);
        test.addK(2, 1);
        test.removeK(2, 1);
        test.removeK(0, 0);
        for (int i = 0; i < test.grid.length; i++) {
            System.out.println(Arrays.toString(test.grid[i]));
        }
        System.out.println();
    }
}
