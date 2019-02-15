public class KnightBoard {

    private int[][] board;
    private boolean isBlank; //this records whether the board is nonempty or not

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
        if (!isBlank){
            throw new IllegalStateException();
        } if (startingRow < 0 || startingRow >= board.length || startingCol < 0 || startingCol >= board[0].length) {
            throw new IllegalArgumentException();
        }
        return solveH(startingRow, startingCol, 1);
    }
    private boolean solveH(int row, int col, int moveNumber) {
        if (moveNumber == board.length * board[0].length + 1) { //base case when you have completed tour
            return true;
        } else {
            if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length || //these test if the knight is out of board
                board[row][col] != 0) { //this tests if the knight is moved to a place already stepped on
                return false;
            } else {
                board[row][col] = moveNumber;
                boolean toReturn = solveH(row + 2, col - 1, moveNumber + 1) || //tests every possible
                                   solveH(row + 2, col + 1, moveNumber + 1) || //move of the knight
                                   solveH(row - 2, col - 1, moveNumber + 1) ||
                                   solveH(row - 2, col + 1, moveNumber + 1) ||
                                   solveH(row + 1, col - 2, moveNumber + 1) ||
                                   solveH(row + 1, col + 2, moveNumber + 1) ||
                                   solveH(row - 1, col - 2, moveNumber + 1) ||
                                   solveH(row - 1, col + 2, moveNumber + 1);
                if (!toReturn) {
                    board[row][col] = 0; //changes back to 0 if no possibilities
                }
                isBlank = !toReturn; //changes isblank for the tostring
                return toReturn;
            }
        }
    }

    public int countSolutions(int startingRow, int startingCol) {
        if (!isBlank){
            throw new IllegalStateException();
        } if (startingRow < 0 || startingRow >= board.length || startingCol < 0 || startingCol >= board[0].length) {
            throw new IllegalArgumentException();
        }
        if (board.length == 1 && board[0].length == 1) {
            return 1;
        }
        return countH(startingRow, startingRow, 1); //temp
    }
    private int countH(int row, int col, int moveNumber) {
        if (moveNumber == board.length * board[0].length + 1) { //base case when you have completed the tour
            return 1;
        } else {
            if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length || //these test if the knight is out of board
                board[row][col] != 0) { //this tests if the knight is moved to a place already stepped on
                return 0;
            } else {
                board[row][col] = moveNumber;
                int toReturn = countH(row + 2, col - 1, moveNumber + 1) + //tests every possible
                               countH(row + 2, col + 1, moveNumber + 1) + //move of the knight
                               countH(row - 2, col - 1, moveNumber + 1) +
                               countH(row - 2, col + 1, moveNumber + 1) +
                               countH(row + 1, col - 2, moveNumber + 1) +
                               countH(row + 1, col + 2, moveNumber + 1) +
                               countH(row - 1, col - 2, moveNumber + 1) +
                               countH(row - 1, col + 2, moveNumber + 1);
                board[row][col] = 0; //after you finish all possibilities, backtrack
                return toReturn; //changing isBlank is unnecessary
            }
        }
    }
}
