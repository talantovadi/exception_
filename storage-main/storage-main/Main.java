public class Main {
    public static void main(String[] args) {
        try {
            PersonalAccount pa = new PersonalAccount(500000, "Dilbar");
            pa.deposit(5000);
            pa.deposit(15000);
            pa.withdraw(3000);
            pa.withdraw(20000);
            System.out.println("Balance: " + pa.getBalance());
            pa.printTransactionHistory();
        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance: " + e.getMessage());
        } catch (InvalidAmountException e) {
            throw new RuntimeException(e);
        }
    }
}
