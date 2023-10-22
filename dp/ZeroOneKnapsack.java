// package dp;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int capacity = 8;
        int [] weight = new int[105];
        int [] value = new int[105];
        long [][] dp = new long[105][100005];
        Arrays.stream(dp).forEach(r->Arrays.fill(r, -1));

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        capacity = input.nextInt();
        for(int i=0; i<n;i++){
            weight[i] = input.nextInt();
            value[i] = input.nextInt();
        }

        long ans = knap(0, capacity, weight, value, dp);
        System.out.println(ans);
    }

    private static long knap(int index, int amount, int[] weight, int[] value, long[][] dp) {
        if(index==weight.length || amount <= 0){
            //System.out.println(amount);
            return 0;
        }
        if(dp[index][amount]!=-1) {
            return dp[index][amount];
        }
        long ans = knap(index+1, amount, weight, value, dp);
        if(amount - weight[index]>=0)
            ans = max(ans,value[index]+ knap(index+1, amount-weight[index], weight, value, dp));

        return dp[index][amount] = ans;
    }
}
