package exception.customException;

public class CustomException extends RuntimeException {
    CustomException() {

    }

    CustomException(String message) {
        super(message);
    }
}
