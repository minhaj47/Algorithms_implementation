package recursion;

public class CountZero {
    public static void main(String[] args) {
        int n = 1014025000;

        int ans = zero(n);
        System.out.println(ans);
    }

    private static int zero(int n) {
//        if(n==0)return 0;
          return helper(n, 0);
//        int count = 0;
//        if(n%10==0)                // this approach is simpler
//            count++;
//        return count + zero(n/10);
    }

    private static int helper(int n, int count) {
        if(n==0)return count;
        if(n%10==0)                       // this is a speacial example that return same value in all calls
            count ++;
        return helper(n/10, count);
    }
}
