package exception.customException;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        if(a<10) {
            throw new CustomException("정수를 초과");
        }
    }
}
