package dp;

import java.util.Arrays;

import static java.lang.Math.min;

public class MCM {
    public static void main(String[] args) {
        int [] d = {5, 4, 6, 4, 5, 4, 5, 45, 43, 5, 25, 62, 24, 5, 2,3, 34, 65,35,6, 5,3,45,3,5,4};
        long dp[][] = new long[200][200];
        Arrays.stream(dp).forEach(r->Arrays.fill(r, -1));
        long ans = mcm(1, d.length-1, d, dp);
        System.out.println(ans);
    }

    private static long mcm(int i, int j, int[] d, long[][] dp) {
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        dp[i][j] = (long)1e19+7;
        for(int k = i; k<j; k++){
            dp[i][j] = min(dp[i][j], mcm(i, k, d, dp) + mcm(k+1, j, d, dp) + d[i-1] * d[k] * d[j]);
        }
        return dp[i][j];
    }
}
