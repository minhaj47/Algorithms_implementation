//package BranchAndBound;

public class NQueens {
    public static void main(String[] args){
        final int N = 4;
        boolean [][] board = new boolean[N][N];
        int ans = queen(0, board, N);
        System.out.println(ans);
    }

    private static int queen(int row, boolean[][] board, int N) {
        if(row == N){
            return 1;
        }
        int cnt = 0;
        for(int i=0; i<N; i++){
            if(isSafe(row, i, board, N)){
                board[row][i] = true;
                cnt += queen(row +1, board, N);
                board[row][i] = false;
            }
        }
        return cnt;
    }

    private static boolean isSafe(int row, int col, boolean[][] board, int N) {
        // up
        int r = row -1;
        while(r>=0){
            if(board[r][col]){
                return false;
            }
            r--;
        }
        // upRight
        r = row -1;
        int c = col+1;
        while(r>=0 && c<N){
            if(board[r][c]){
                return false;
            }
            r--;
            c++;
        }
        // upLeft
        
        r = row -1;
        c = col -1;
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
