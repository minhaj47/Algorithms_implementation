package recursion;

public class DigitSum {
    public static void main(String[] args) {
        int n = 15478;
        int sum = sum(n);
        System.out.println(sum);
    }
    static int sum(int n){
        if(n==0)return 0;
        return (n%10) + sum(n/10);
    }
}
