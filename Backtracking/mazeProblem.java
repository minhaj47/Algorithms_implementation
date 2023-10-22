package Backtracking;

import java.util.Arrays;

public class mazeProblem {
    public static void main(String[] args) {
        int row = 25;
        int col = 25;
        boolean board[][] = new boolean[row][col];
        int dp[][] = new int[row+1][col+1];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        int pathCount = maze(board, 0, 0, row, col, dp);
        System.out.println(pathCount);
    }
    public static int maze(boolean[][] board, int r, int c, int row, int col, int [][] dp){
        if(dp[r][c]!=-1)return dp[r][c];
        if(c== col-1 || r == row-1){
            return 1;
        }
        int count =0;
        count += maze(board, r+1, c, row, col, dp);
        count += maze(board, r, c+1, row, col, dp);

        return dp[r][c] = count;
    }
}
