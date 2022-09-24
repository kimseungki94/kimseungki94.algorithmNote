package exception.customException;

public class CheckedCustomException extends Exception {
    public CheckedCustomException() {
    }

    public CheckedCustomException(String message) {
        super(message);
    }
}
