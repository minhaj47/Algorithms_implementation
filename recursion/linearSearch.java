package recursion;

import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args) {
        int[] a = {2, 4, 5, 6, 3 , 2, 8, 4, 2};
        ArrayList<Integer> list = new  ArrayList<>();
        search(a, 0, 2, list);   // efficient
        //list = search2(a, 0, 2);
        System.out.println(list);
    }

    private static ArrayList<Integer> search(int[] a, int index, int target, ArrayList<Integer> list) {
        if(a[index] == target){
            list.add(index);
        }
        if(index == a.length -1){
            return list;
        }
        return search(a, index+1, target, list);
    }
    private static ArrayList<Integer> search2(int[] a, int index, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        if(a[index] == target){
            list.add(index);
        }
        if(index == a.length -1){
            return list;
        }
        ArrayList<Integer> fromBellow = search2(a, index+1, target);

        list.addAll(fromBellow);
        return list;
    }
}
