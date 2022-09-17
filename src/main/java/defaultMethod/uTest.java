package defaultMethod;

public interface uTest {
    default void dTest() {
        System.out.println("sd");
    }
}
