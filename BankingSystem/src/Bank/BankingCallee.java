public class BankingSystem {
    private double balance;
    private String accountNumber;
    private String accountHolder;
    private String[] transactionHistory;
    private int transactionCount;

    // Constructor
    public BankingSystem(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new String[100];
        this.transactionCount = 0;
    }

    // Function to deposit money
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit: +" + amount);
            return true;
        } else {
            System.out.println("Invalid deposit amount. Amount must be positive.");
            return false;
        }
    }

    // Function to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                addTransaction("Withdrawal: -" + amount);
                return true;
            } else {
                System.out.println("Insufficient funds!");
                return false;
            }
        } else {
            System.out.println("Invalid withdrawal amount. Amount must be positive.");
            return false;
        }
    }

    // Function to add transaction to history
    private void addTransaction(String transaction) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount] = transaction;
            transactionCount++;
        }
    }

    // Function to display transaction history
    public void displayTransactionHistory() {
        System.out.println("\nTransaction History for Account: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("----------------------------------------");
        
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactionHistory[i]);
        }
        
        System.out.println("----------------------------------------");
        System.out.println("Current Balance: $" + balance);
    }

    // Function to check balance
    public double getBalance() {
        return balance;
    }

    // Main method to demonstrate the banking system
    public static void main(String[] args) {
        // Create a new bank account
        BankingSystem account = new BankingSystem("John Doe", "1234567890", 1000.0);
        
        // Perform some transactions using while loop
        int operation = 1;
        while (operation <= 3) {
            switch (operation) {
                case 1:
                    account.deposit(500.0);
                    break;
                case 2:
                    account.withdraw(200.0);
                    break;
                case 3:
                    account.withdraw(1500.0); // This should fail
                    break;
            }
            operation++;
        }

        // Process multiple deposits using for loop
        double[] deposits = {100.0, 200.0, 300.0};
        for (double deposit : deposits) {
            account.deposit(deposit);
        }

        // Display final transaction history
        account.displayTransactionHistory();
    }
}