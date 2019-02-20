import java.util.Arrays;

public class Moves {

    public int[][] grid; //make private later

    private int totalBeginning(int row, int col) { //function that determines number of moves
        int[] options = {2, -1, 2, 1, -2, -1, -2, 1, 1, -2, 1, 2, -1, -2, -1, 2};
        int count = 0;
        return count;
    }

    public Moves(int rows, int cols) { //constructor makes all the moves in rows x cols board
        grid = new int[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

            }
        }
    }
    public static void main(String[] args) {
        Moves test = new Moves(4, 3);
        for (int i = 0; i < test.grid.length; i++) {
            System.out.println(Arrays.toString(test.grid[i]));
        }
    }
}
