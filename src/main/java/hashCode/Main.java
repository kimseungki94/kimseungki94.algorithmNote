package hashCode;

public class Main {
    public static void main(String[] args) {
        String str1 = new String("A");
        String str2 = new String("A");
        System.out.println(str1==str2);
        System.out.println(str1.hashCode()==str2.hashCode());
    }
}
