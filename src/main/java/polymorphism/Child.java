package polymorphism;

public class Child extends Parent {
    @Override
    public String print() {
        return "child Print()";
    }
    public String parentPrint() {
        return super.print();
    }
}
