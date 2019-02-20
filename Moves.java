public class Moves {

    public int[][] grid; //make private later

    public Moves(int rows, int cols) { //constructor makes all the moves in rows x cols board
        grid = new int[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || i == grid.length - 1) {
                    if (j == 0 || j == grid[i].length - 1) {
                        grid[i][j] = 2; //this is 0,0
                    } else if (j == 1 || j == grid[i].length - 2) {
                        grid[i][j] = 3; //this is 0,1
                    } else {
                        grid[i][j] = 4; //this is 0,anythingelse
                    }
                } else if (i == 1 || i == grid.length - 2) {
                    if (j == 0 || j == grid[i].length - 1) {
                        grid[i][j] = 3; //this is 1,0
                    } else if (j == 1 || j == grid[i].length - 2) {
                        grid[i][j] = 4; //this is 1,1
                    } else {
                        grid[i][j] = 6; //this is 1,anythingelse
                    }
                } else {
                    if (j == 0 || j == grid[i].length - 1) {
                        grid[i][j] = 4; //this is 2,0
                    } else if (j == 1 || j == grid[i].length - 2) {
                        grid[i][j] = 6; //this is 2,1
                    } else {
                        grid[i][j] = 8; //this is 2,anythingelse
                    }
                }
            }
        }
    }
}
