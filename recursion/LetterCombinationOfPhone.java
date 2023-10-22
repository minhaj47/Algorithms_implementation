package recursion;

import java.util.*;

public class LetterCombinationOfPhone {
    public static void main(String[] args) {
        ArrayList<String> ans = PhonePad("", "23");
        System.out.println(ans);
        int count = count("23", "");
        System.out.println(count);
    }

    private static int count(String up, String p) {
        if(up.isEmpty()){
            return 1;
        }
        int n  = up.charAt(0) - '0';
        n--;
        int count =0;
        for(int i = 3*(n-1); i<n*3; i++){
            count+= count(up.substring(1), p + (char) ('a' +i));
        }
        return count;
    }

    //static int count = 0;
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

        for(int i=(n-1)*3; i<n*3; i++){
            list.addAll(PhonePad(p + (char) ('a'+ i), up.substring(1)));
        }
        return list;
    }
}
