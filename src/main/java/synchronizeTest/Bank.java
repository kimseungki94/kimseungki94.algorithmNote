package synchronizeTest;

public class Bank {
    private int money;

    public Bank() {
        this.money = 1000;
    }

    public void plusMoney(int value) {
        money += value;
    }

    public int getMoney() {
        return money;
    }
}
