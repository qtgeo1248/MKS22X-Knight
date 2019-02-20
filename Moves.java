public class Moves {

    public int[][] grid; //make private later

    public Moves(int rows, int cols) { //constructor makes all the moves in rows x cols board
        grid = new int[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            if (i == 0) {

            } else if (i == 1) {

            } else if (i == grid.length - 1) {

            } else if (i == grid.length) {

            } else {
                
            }
        }
    }
}
