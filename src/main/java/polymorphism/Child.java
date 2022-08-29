package polymorphism;

public class Child extends Parent {
    public Child(int son) {
        super(son);
    }

    @Override
    public String print() {
        return "child Print()";
    }
    public String parentPrint() {
        return super.print();
    }
}
