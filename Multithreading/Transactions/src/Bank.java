import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        if (accounts.get(fromAccountNum).getIsWorking() & accounts.get(toAccountNum).getIsWorking()) {
            if (accounts.get(fromAccountNum).getFromAccount(amount)) {
                accounts.get(toAccountNum).addToAccount(amount);
                if (amount > 50000) {
                    try {
                        boolean fraudOperation = isFraud(fromAccountNum, toAccountNum, amount);
                        if (fraudOperation) {
                            accounts.get(fromAccountNum).setIsWorking(false);
                            accounts.get(toAccountNum).setIsWorking(false);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("exception here");
                    }
                }
            }
        }
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }
}
