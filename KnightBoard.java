public class KnightBoard {

    private int[][] board;
    private boolean isBlank; //this records whether the board is nonempty or not
    private Moves allPossMoves;
    private static int[] OPTIONS = {2, -1, 2, 1, -2, -1, -2, 1, 1, -2, 1, 2, -1, -2, -1, 2};

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
        allPossMoves = new Moves(startingRows, startingCols);
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
                boolean toReturn = false;
                for (int i = 0; i < OPTIONS.length; i += 2) {
                    toReturn = toReturn || solveH(row + OPTIONS[i], col + OPTIONS[i + 1], moveNumber + 1); //tests every possible move of the knight
                }
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
        return countH(startingRow, startingRow, 1) / 8;
        /* okay so be prepared for the longest comment you ever read MR. KONSTANTINOVICH because it's
           about to be THE longest comment ever so here's the mathematical reason why I divide by 8:
           whenever I reach the last step of a VALID TOUR, I call the recursive step one more time.
           Would you that if I move the knight to ANY space on the board after the last step of a tour,
           the knight would move either to an invalid spot, or to a spot it has already reached? However,
           due to the lack of my coding abilities, I am unable to code the fact that if i'm at the last step,
           check if it's valid and then return 1, so I am forced to call the recursive step one more time.
           By doing so, I multiply the number of solutions by 8, since every step after the ending of a
           knight's tour would create an invalid solution (which my code would return as a valid solution),
           and also due to the fact that technically, a knight always has 8 spots to move (whether the spot
           is on the board is valid is a different question itself). Therefore, I overcounted by a factor
           of 8 with my recursive calls. So therefore, I'm dividing by 8 by my solution to get the correct solution

           PS, tl;dr: I explained why I divided by 8
           PPS, I'm sorry you have had to read this massive comment which probably added like 15 lines to my code
                but I hope it was worth your while
           PPS, Please do not roast me in class I'm begging you
           PPPS, I'm sorry for sleeping in class the other day I had only 2 hours of sleep
           PPPPS, I hope this goes in to some world record or Stuy record for longest useful comment ever
           PPPPPS, Now I actually hope you don't read this at all and you don't actually read our code when grading labs
                   because it's getting ridiculously long and embarrassing
           PPPPPPS, Happy Valentine's Day!! (as of the time I wrote this comment)
        */
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
                int toReturn = 0;
                for (int i = 0; i < OPTIONS.length; i += 2) {
                    toReturn += countH(row + OPTIONS[i], col + OPTIONS[i + 1], moveNumber + 1); //tests every possible move of the knight
                }
                board[row][col] = 0; //after you finish all possibilities, backtrack
                return toReturn; //changing isBlank is unnecessary
            }
        }
    }
}
