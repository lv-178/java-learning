public class Account {

    private long money;
    private String accNumber;
    private boolean isWorking;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
        isWorking = true;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public boolean getFromAccount(long money) {
        if (this.money >= money & isWorking) {
            this.money -= money;
            System.out.println("выполнен перевод с аккаунта " + accNumber + " на сумму " + money);
            return true;
        }
        if (isWorking) {
            System.out.println("операция отклонена, недостаточно денег на счёте");
        } else {
            System.out.println("операция отклонена, счёт заблокирован");
        }
        return false;
    }

    public boolean addToAccount(long money) {
        if (isWorking) {
            this.money += money;
            return true;
        }
        System.out.println("счёт заблокирован");
        return false;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean newStatus) {
        isWorking = newStatus;
        System.out.println("счёт " + accNumber + " заблокирован за попытку мошенничества!");
    }

    @Override
    public String toString() {
        return "account number: " + accNumber + "; money: " + money + " "
                + (isWorking ? "working" : "blocked");
    }
}
