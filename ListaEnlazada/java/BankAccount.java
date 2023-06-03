public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private int centsBalance;

    public BankAccount(String holder, String number, int balance){
        this.accountHolder = holder;
        this.accountNumber = number;
        this.centsBalance = balance*100;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getCentsBalance() {
        return centsBalance/100;
    }
}
