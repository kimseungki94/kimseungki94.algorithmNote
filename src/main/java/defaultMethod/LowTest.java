package defaultMethod;

public class LowTest implements ITest,uTest{
    public void low() {
        System.out.println("low");
    }

    public void test() {
    }

    @Override
    public void dTest() {
        ITest.super.dTest();
    }
}
