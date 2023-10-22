package recursion;

public class skipSubString {
    public static void main(String[] args) {
        String s = "kdfdkapplelfd";
        String pattern = "apple";
        String ans = skip(s, pattern);
        System.out.println(ans);
    }

    private static String skip(String s, String pattern) {
        if(s.isEmpty()){
            return "";
        }

        if(s.startsWith("apple")){
            return skip(s.substring(pattern.length()), pattern);
        }
        else {
            return s.charAt(0) + skip(s.substring(1), pattern);
        }
    }

}