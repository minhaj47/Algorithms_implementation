package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 24, 33, 90};
        int size = 6;
        int ans = bSearch(arr,90, 0, size-1);
        System.out.println(ans);
    }

    private static int bSearch(int[] a, int target, int bg, int end) {
        if(bg>end) {
            return -1;
        }
        int mid = (bg+end)/2;
        if(a[mid] == target){
            return mid;
        }
        if(a[mid]>target){
            return bSearch(a, target, bg, mid-1);
        }
        return bSearch(a, target, mid+1, end);
    }
}
