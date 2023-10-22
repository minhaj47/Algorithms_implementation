package recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int []  a = {1, 5, 3, 9, 6, 7};
        selection(a, a.length, 0, 0);

        System.out.println(Arrays.toString(a));
    }

    private static void selection(int[] a, int length, int c, int max) {
        if(length==0)return;
        if(length>c){
            if(a[c]>a[max])max=c;
            selection(a, length, c+1, max);
        }
        else{
            length--;
            //swap
            int temp = a[length];
            a[length] = a[max];
            a[max] = temp;
            selection(a, length, 0, 0);
        }
    }
}
