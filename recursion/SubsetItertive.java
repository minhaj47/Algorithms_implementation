package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetItertive {
    public static void main(String[] args) {
        int [] a = {1, 3, 4, 4};
        List<List<Integer>> ans = subset(a);
        System.out.println(ans);
        List<List<Integer>> ans2 = subsetHandlingDuplicate(a);
        System.out.println(ans2);
    }

    static List<List<Integer>> subset(int [] a){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        for(int x : a){

            int n = outer.size();
            for(int i=0; i<n; i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(x);
                outer.add(inner);
            }
        }
        return outer;
    }

    static List<List<Integer>> subsetHandlingDuplicate(int [] a){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        Arrays.sort(a);
        for(int i=0; i<a.length; i++){
            int x = a[i];
            int n = outer.size();
            int start = 0;
            if(i>0 && a[i] == a[i-1]){
                start = n/2;
            }
            for(int j=start; j<n; j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(x);
                outer.add(inner);
            }
        }
        return outer;
    }

}
