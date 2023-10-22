package recursion;

import java.util.Scanner;

public class ReverseNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        //rev(n);
        System.out.println(rev2(n));
    }
//    static int rev = 0;
//    private static void rev(int n) {
//
//        if(n==0)return;   //base
//        int d = n%10;
//        rev = rev*10 +d;
//        rev(n/10);
//    }

    private static int rev2(int n){
        int digit = (int) Math.log10(n) + 1;
        return  helper(n, digit);
    }

    private static int helper(int n, int digit) {
        int rem = n%10;
        if(n == rem)return n;  // or if(digit == 1) return n; or if(n==0) return 0;

        int ans = (int)(rem * Math.pow(10, digit-1)) + helper(n/10, digit-1);
        return ans;
    }
}
