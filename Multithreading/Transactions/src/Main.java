import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Account> accounts = new HashMap<>();
        for (int i = 1; i <= 8; i++) {
            accounts.put(i + "", new Account(i + "", 200000));
        }
        Bank bank = new Bank(accounts);

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bank.transfer("1", "2", Math.round(Math.random() * 55000));
                bank.getBalance("1");
                bank.transfer("2", "1", Math.round(Math.random() * 55000));
                bank.getBalance("2");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bank.transfer("3", "4", Math.round(Math.random() * 55000));
                bank.getBalance("3");
                bank.transfer("4", "3", Math.round(Math.random() * 55000));
                bank.getBalance("4");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bank.transfer("5", "6", Math.round(Math.random() * 55000));
                bank.getBalance("5");
                bank.transfer("6", "5", Math.round(Math.random() * 55000));
                bank.getBalance("6");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bank.transfer("7", "8", Math.round(Math.random() * 55000));
                bank.getBalance("7");
                bank.transfer("8", "7", Math.round(Math.random() * 55000));
                bank.getBalance("8");
            }
        }).start();
    }
}
