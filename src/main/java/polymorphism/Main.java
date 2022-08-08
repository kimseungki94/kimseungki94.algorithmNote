package polymorphism;

public class Main {
    public static void main(String[] args) {
        Parent child = new Child();
        Child c = (Child) child;
        System.out.println(child.print());
        System.out.println(c.parentPrint());
    }
}
