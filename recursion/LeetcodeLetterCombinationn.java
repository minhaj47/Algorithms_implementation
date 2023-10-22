package recursion;

import java.util.*;

public class LeetcodeLetterCombinationn {
    public static void main(String[] args) {
        ArrayList<String> ans = PhonePad("", "23");
        System.out.println(ans);
    }

    static ArrayList<String> PhonePad(String p, String up){
        ArrayList<String> list = new ArrayList<>();
        if(up.isEmpty()){
            //System.out.println(p);
            list.add(p);
            //count ++;
            return list;
        }
        int n = up.charAt(0) - '0';
        n-=1;
        int m = 0;
        if(n== 6 || n==8 ){
            m=1;
        }
        int f =0;
        if(n>6){
            f=1;
        }

        for(int i=(n-1)*3+f; i<n*3+m+f; i++){
            list.addAll(PhonePad(p + (char) ('a'+ i), up.substring(1)));
        }

        return list;
    }
}
