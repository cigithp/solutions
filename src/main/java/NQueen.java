import java.util.Arrays;

public class NQueen {

    final static int N = 8;

    //display board
    public void displayBoard(char[][] board) {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                System.out.print(" "+board[i][j]+" ");
            System.out.println();
        }

    }

    //isSafe
    public boolean isSafe(char[][] board, int row, int col) {

        //check left on the same row
        for(int i = 0; i < col; i++)
            if(board[row][i] == 'Q')
                return false;

        //check upper left diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if(board[i][j] == 'Q')
                return false;

        //check lower left diagonal
        for(int i = row, j = col; i < N && j >= 0; i++, j--)
            if(board[i][j] == 'Q')
                return false;

        return true;
    }

    //solveNQueen
    public void solveNQueen(char[][] board) {
        solveNQueenHelper(board, 0);
    }

    public void solveNQueenHelper(char[][] board, int col) {
        if(col >= N) {
            //base case
            displayBoard(board);
            System.out.println("---------------------------------");
        } else {
            //recursive case
            for(int i = 0; i < N; i++) {
                if(isSafe(board, i, col)) {
                    board[i][col] = 'Q';
                    solveNQueenHelper(board, col + 1);
                    board[i][col] = '.';
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] board = new char[N][N];
        for(int i = 0; i < N; i++)
            Arrays.fill(board[i], '.');
        NQueen n = new NQueen();
        n.solveNQueen(board);

    }


}
