public class KnightBoard {

    int[][] board;
    boolean isBlank;

    public KnightBoard(int startingRows, int startingCols) {
        if (startingRows <= 0 || startingCols <= 0) {
            throw new IllegalArgumentException();
        }
        board = new int[startingRows][startingCols];
        isBlank = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public String toString() {
        String ans = "";
        if (isBlank) {

        } else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {

                }
            }
        }
        return ans;
    }
}
