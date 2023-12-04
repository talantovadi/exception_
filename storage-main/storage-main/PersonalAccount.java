import java.util.ArrayList;
public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    ArrayList <Amount> transactions = new ArrayList<Amount>();

    public PersonalAccount(int accountNumber, String accountHolder){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount > 0) {
            this.balance += amount;
            Amount transaction = new Amount(amount, "deposit");
            this.transactions.add(transaction);
        } else {
            throw new InvalidAmountException("Deposit amount must be greater than 0.");
        }
    }
    public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException {
        if (amount > 0) {
            if (balance >= amount) {
                this.balance -= amount;
                Amount transaction = new Amount(amount, "withdraw");
                this.transactions.add(transaction);
            } else {
                throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
            }
        } else {
            throw new InvalidAmountException("Withdrawal amount must be greater than 0.");
        }
    }
    public void printTransactionHistory(){
        for (Amount a1: transactions){
            System.out.println(a1);
        }
    }
    public double getBalance() {
        return balance;    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
}
