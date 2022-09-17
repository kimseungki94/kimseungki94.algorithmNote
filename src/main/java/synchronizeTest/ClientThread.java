package synchronizeTest;

public class ClientThread extends Thread{
    Bank bank;

    public ClientThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            bank.plusMoney(1);
        }
    }
}
