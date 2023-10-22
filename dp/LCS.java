//package dp;

import static java.lang.Math.max;

public class LCS {
    public static void main(String[] args) {
        String a = "adfjdafkjbjdopcfudsopfodspifdsopfiddspfopdfjsdopfsdpaofjaopfjopcd\0";
        String b = "abcd\0";
        int dp[][] = new int[100][100];
        int ans = lcs(0, 0, a, b, dp);
        System.out.println(ans);
    }

    private static int lcs(int i, int j, String a, String b, int [][] dp) {
        if(a.charAt(i) == '\0' || b.charAt(j) == '\0'){
            return 0;
        }
        if(a.charAt(i) == b.charAt(j)){
            return dp[i] [j] = 1 + lcs(i+1, j+1, a, b, dp);
        }
        return dp[i][j] = max(lcs(i, j+1, a, b, dp), lcs(i+1, j, a, b, dp));
    }
}
