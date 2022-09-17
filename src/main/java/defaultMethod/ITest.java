package defaultMethod;

public interface ITest {
    static void test() {
        System.out.println("sd");
    }
    default void dTest() {
        System.out.println("default");
    }
}
