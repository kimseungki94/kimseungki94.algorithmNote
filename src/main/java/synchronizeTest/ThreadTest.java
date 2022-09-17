package synchronizeTest;

public class ThreadTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ClientThread client1 = new ClientThread(bank);
        ClientThread client2 = new ClientThread(bank);

        client1.start();
        client2.start();
        try{
            client1.join();
            client2.join();
            // 해당 결과는 동기처리 시, 3000이 나와야 함
            System.out.println(bank.getMoney());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
