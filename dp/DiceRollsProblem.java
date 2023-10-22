package dp;

import java.util.Arrays;

public class DiceRollsProblem {
    public static void main(String[] args) {
        int n = 30;
        int k = 30;
        int target = 500;
        Integer [] [] dp = new Integer[n+1][1005];
        int ans = roll(n, k, target, dp);
        System.out.println(ans);
    }
    static int mod = (int) (1e9+7);
    private static int roll(int n, int k, int target, Integer [][] dp) {

        if(target<0){
            return 0;
        }
        if(n==0){
            if(target==0){
                return 1;
            }
            return 0;
        }
        if(dp[n][target]!= null){
            return dp[n][target];
        }
        int count =0;
        for(int i=1; i<=k; i++){
            count = (count + roll(n-1, k, target-i, dp))%mod ;
        }
        return dp[n][target] = count;
    }
}
