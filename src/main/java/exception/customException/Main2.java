package exception.customException;

public class Main2 {
    public static void main(String[] args) throws CheckedCustomException {
        int a = 5;
        if(a<10) {
            throw new CheckedCustomException("정수를 초과");
        }
    }
}

