public class Moves {

    public int[][] grid; //make private later

    public Moves(int rows, int cols) { //constructor makes all the moves in rows x cols board
        grid = new int[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0) {
                    if (j == 0 || j == grid[i].length - 1) {
                        grid[i][j] = 2; //this is corner
                    } else if (j == 1 || j == grid[i].length - 2) {
                        grid[i][j] = 3; //this is near corner
                    } else {
                        grid[i][j] = 4; //this is nonspecial edges
                    }
                } else if (i == 1) {

                } else if (i == grid.length - 1) {

                } else if (i == grid.length) {

                } else {

                }
            }
        }
    }
}
