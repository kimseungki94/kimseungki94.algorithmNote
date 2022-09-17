package stringTest;

public class Main {
    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        printTest(a,b);
        String c = new String("a");
        String d = new String("a");
        printTest(c,d);
    }

    public static void printTest(String a,String b) {
        System.out.println(a==b);
        System.out.println(a.hashCode()==b.hashCode());
        System.out.println(a.equals(b));
    }
}
