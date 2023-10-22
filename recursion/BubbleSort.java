package recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int []  a = {1, 5, 3, 9, 6, 7};
        bubble(a, a.length-1, 0);
//        for(int i: a){
//            System.out.print(i +" ");
//        }
        System.out.println(Arrays.toString(a));

    }
    static void bubble(int[] a, int length, int c){
        if(length==0)return;
        if(length>c){
            if(a[c]>a[c+1]) {
                int temp = a[c];
                a[c] = a[c+1];
                a[c+1] = temp;
            }
            bubble(a, length, c+1);
        }
        else {
            bubble(a, length-1, 0);
        }
    }
}
