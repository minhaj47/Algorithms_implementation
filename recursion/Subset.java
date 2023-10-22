package recursion;

import java.util.ArrayList;

public class Subset {
    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> ans = subset2(s, "");
        System.out.println(ans);
        // subset(s, "");


    }

    private static void subset(String s, String ans) {
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        char c = s.charAt(0);
        subset(s.substring(1), ans + c);
        subset(s.substring(1), ans);
    }

    private static ArrayList<String> subset2(String s, String ans) {
        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char c = s.charAt(0);
        ArrayList<String> left = subset2(s.substring(1), ans + c);
        ArrayList<String> right = subset2(s.substring(1), ans);

        left.addAll(right);

        return left;
    }

}
