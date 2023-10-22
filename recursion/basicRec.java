public class basicRec{
    public static void main(String[] args){
        massage();
    }

    static void massage() {
        System.out.println("Hello ");
        massage1();
    }

    static void massage1() {
        System.out.println("Hello ");
        massage2();
    }

    static void massage2() {
        System.out.println("Hello ");
        massage3();
    }

    static void massage3() {
        System.out.println("Hello ");
    }
}