package polymorphism;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parent p1 = new Parent(23);
        Parent p2 = new Parent(23);

        HashMap<Parent,Integer> hashMap = new HashMap<>();
        hashMap.put(p1,1);
        hashMap.put(p2,2);
        System.out.println(hashMap.size());
    }
    public void test(ArrayList<? extends Parent> c) {
        Parent p = c.get(0);
        System.out.println(c);
    }
}
