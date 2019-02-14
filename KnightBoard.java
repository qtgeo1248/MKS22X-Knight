public class KnightBoard {

    public int[][] board;
    public boolean isBlank; //this records whether the board is nonempty or not

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
        if (isBlank) { //this does the case when the board is blank
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    ans += "__ ";
                }
                ans = ans.substring(0, ans.length() - 1) + "\n"; //this removes the extra space
            }
        } else { //this does the case when solve or countSols have been called
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] / 10 < 1) { //this does the single digit case
                        ans += " " + board[i][j] + " ";
                    } else { //this does the double digit case
                        ans += board[i][j] + " ";
                    }
                }
                ans = ans.substring(0, ans.length() - 1) + "\n"; //this removes extra space
            }
        }
        return ans.substring(0, ans.length() - 1); //this removes the extra line
    }

    public boolean solve(int startingRow, int startingCol) {
        return solveH(startingRow, startingCol, 1);
    }
    public boolean solveH(int row, int col, int level) {//MAKE PRIVATE LATER
        if (level == 26) {
            return true;
        } else {

        }
    }
}
