package stringTest;

import polymorphism.Parent;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        printTest(a,b);
        String c = new String("a");
        String d = new String("a");
        printTest(c,d);
        Object o1 = new Object();
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        System.out.println(hashMap);
        Parent p1 = new Parent(1);
        Parent p2 = new Parent(1);
        p1=p2;
    }

    public static void printTest(String a,String b) {
        System.out.println(a==b);
        System.out.println(a.hashCode()==b.hashCode());
        System.out.println(a.equals(b));
    }
}
