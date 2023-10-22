package Backtracking;

public class NQueensProblem {
    public static void main(String[] args){
        int N =4;
        boolean[][] board = new boolean[N][N];
        int ans = queen(board, 0, N);
        System.out.println(ans);
    }

    private static int queen(boolean[][] board, int row, int N) {
        if(row == N){  // 0 based indexing where 4 is the 5th row 
            disply(board);
            return 1;
        }
        int cnt = 0;
        for(int col = 0; col <N; col++){
            if(valid(board, row, col, N)){
                board[row][col] = true;
                cnt+=queen(board, row+1,N);
                board[row][col] = false;
            }
        }
        return cnt;
    }

    private static void disply(boolean[][] board) {
        for (boolean[] row : board) {
            for (int j = 0; j < board.length; j++) {
                if (row[j]) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean valid(boolean [][] board, int row, int col, int N) {
        // up
        int r = row-1;
        while(r>=0){
            if(board[r][col]){
                return false;
            }
            r--;
        }
        //upright
        r = row-1;
        int c = col+1;
        while(r>=0 && c<N){
            if(board[r][c]){
                return false;
            }
            r--;
            c++;
        }

        //upleft
        r = row-1;
        c = col-1;
        while(r>=0 && c>=0){
            if(board[r][c]){
                return false;
            }
            r--;
            c--;
        }

        return true;
    }
    
}
