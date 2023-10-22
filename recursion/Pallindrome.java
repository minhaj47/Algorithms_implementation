package recursion;

import java.util.Scanner;

public class Pallindrome {
    public static void main(String[] args) {
        String s = args[0];
        //System.out.println(s);
        boolean ans = pal(s, 0, s.length()-1);
        System.out.println(ans);
    }
    private static boolean pal(String s, int bg, int end){
        if(bg>=end)return true;
        boolean cur = (s.charAt(end) == s.charAt(bg));
        return cur &&  pal(s, ++bg, --end);
    }
}
