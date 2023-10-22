package recursion;

public class ReductionStepstoZero {
    public static void main(String[] args) {
        int n = 14;
        int ans = steps(n);
        System.out.println(ans);
    }

    private static int steps(int n) {
        if(n==0)return 0;
        if(n%2 == 1)n--;
        else n/=2;
        int ans = 1 + steps(n);
        return ans;
    }
}
