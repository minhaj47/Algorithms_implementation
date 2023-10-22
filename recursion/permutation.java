package recursion;

import java.util.ArrayList;

public class permutation {
    public static void main(String[] args) {
        String unpr = "abcd", pr = "";
        //per(unpr, pr);
//        ArrayList<String> ans = per2(unpr, pr, new ArrayList<>());
        ArrayList<String> ans = per3(unpr, pr);
        System.out.println(ans);
        System.out.println(count(unpr, pr));
    }

    private static void per(String unpr , String pr) {
        if(unpr.isEmpty()){
            System.out.println(pr);
            return;
        }
        char c = unpr.charAt(0);
        for(int i=0; i<pr.length()+1; i++){
            String frst = pr.substring(0, i);
            String sec = pr.substring(i);

            per(unpr.substring(1), frst + c + sec);
        }
    }
    private static ArrayList<String> per2(String unpr , String pr, ArrayList<String> list) {
        if(unpr.isEmpty()){
            list.add(pr);
            return list;
        }
        char c = unpr.charAt(0);
        //ArrayList<String> temp = new ArrayList<>();
        for(int i=0; i<pr.length()+1; i++){
            String frst = pr.substring(0, i);
            String sec = pr.substring(i);

            per2(unpr.substring(1), frst + c + sec, list);
        }
        return list;
    }

    private static ArrayList<String> per3(String unpr , String pr) {
        ArrayList<String> list = new ArrayList<>();
        if(unpr.isEmpty()){
            list.add(pr);
            return list;
        }
        char c = unpr.charAt(0);
        //ArrayList<String> temp = new ArrayList<>();
        for(int i=0; i<pr.length()+1; i++){
            String frst = pr.substring(0, i);
            String sec = pr.substring(i);

            list.addAll(per3(unpr.substring(1), frst + c + sec));;
        }
        return list;
    }
    static int count(String up, String p){
        if(up.isEmpty()){
            return 1;
        }
        char c = up.charAt(0);
        int count = 0;
        for(int i=0; i<p.length()+1; i++){
            String f = p.substring(0, i);
            String s = p.substring(i);

            count += count(up.substring(1), f + c + s);
        }
        return count;
    }
}
