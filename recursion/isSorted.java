package recursion;

public class isSorted {
    public static void main(String[] args) {
        int[] a = {1, 20, 3, 40, 4, 6, 8, 9};
        boolean ans = check(a, 0);
        System.out.println(ans);
    }
    public static boolean check(int[] a, int index){
        if(index == a.length-1) {
            return true;
        }
        return a[index] <= a[index+1] && check(a, index+1);
    }
}
