
import java.util.ArrayList;
import java.util.List;

public class MazeSolver {
    /**
     * given a board where '0' = wall and '1' = no wall and start position - find out the path to goal
     * [ [S,0,0,0],
     *   [1,0,1,G],
     *   [1,1,1,0]]
     * return true
     *
     *
     *
     */

    public static boolean isPathExists(char[][] board, int[] start, int[] goal) {
        if(board == null)
            return false;
        int m = board.length, n = board[0].length;
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == start[0] && j == start[1])
                    if(dfs(i, j, board, goal, visited))
                        return true;
            }
        }
       return false;
    }

    private static void display(int[][] board) {
        System.out.println("\nBoard: ");
        for(int i = 0; i < board.length; i++) {
            System.out.println("");
            for(int j = 0; j < board[0].length; j++) {
                System.out.print("\t"+board[i][j]);
            }
        }
    }
    private static List<List<Integer>> getPath(int[][] visited) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                if(visited[i][j] == 1) {
                    temp.add(i);
                    temp.add(j);
                    res.add(new ArrayList<>(temp));
                }
            }
        }
        return res;
    }
    private static boolean dfs(int i, int j, char[][] board, int[] goal, int[][] visited) {
        display(visited);
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '0' || visited[i][j] == 1)
            return false;
        if(i == goal[0] && j == goal[1]) {
            visited[i][j] = 1;
            display(visited);
            //System.out.println("\nPath: "+getPath(visited));
            return true;
        }
        boolean res = false;
        visited[i][j] = 1;
        res = dfs(i+1, j, board, goal, visited) ||
            dfs(i-1, j, board, goal, visited) ||
            dfs(i, j+1, board, goal, visited) ||
            dfs(i, j-1, board, goal, visited);
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board[0][0] = '1';
        board[0][1] = '0';
        board[0][2] = '0';
        board[0][3] = '0';
        board[1][0] = '1';
        board[1][1] = '0';
        board[1][2] = '1';
        board[1][3] = '1';
        board[2][0] = '1';
        board[2][1] = '1';
        board[2][2] = '1';
        board[2][3] = '0';
        System.out.println("\nResult : "+MazeSolver.isPathExists(board, new int[]{0,0}, new int[]{1,3}));
    }




}
