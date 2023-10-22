package dp;

import java.util.Arrays;

import static java.lang.Math.max;

public class RodCutting {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] cut = {1, 2, 3, 4, 5, 6, 7, 8};
        int [] dp = new int[10005];
        Arrays.fill(dp, -1);
        int length = 8;

        int ans = rodCut(length, price, cut, dp);
        System.out.println(ans);
    }

    private static int rodCut(int length, int[] price, int[] cut, int[] dp) {     /// 1D recursion and dp
        if(length == 0){
            return 0;
        }
        if(dp[length]!=-1)
            return dp[length];
        int count = 0;
        for(int i=0; i<cut.length; i++){
            if(length - cut[i] >=0)
                count = max(count, rodCut(length-cut[i], price, cut, dp) + price[i]);
        }
        return dp[length]= count;
    }
}
