package recursion;

public class skipChar {
    public static void main(String[] args) {
        String s = "kdfdkjfdklfd";
        String ans = skip(s);
        System.out.println(ans);
    }

    private static String skip(String s) {
        if(s.isEmpty()){
            return "";
        }
        char c = s.charAt(0);
        if(c=='k'){
            return skip(s.substring(1));
        }
        else {
            return c + skip(s.substring(1));
        }
    }

}
