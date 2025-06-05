import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    String name;
    double loanAmount;

    public Account(String name, double loanAmount) {
        this.name = name;
        this.loanAmount = loanAmount;
    }
}

public class LoanManagement {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Alice", 10000.0));
        accounts.add(new Account("Bob", 5000.0));
        accounts.add(new Account("Charlie", 0.0));
        accounts.add(new Account("Diana", 25000.0));

        Scanner scanner = new Scanner(System.in);
        int choice;
        String name;

        do {
            System.out.println("\n--- Loan Management Menu ---");
            System.out.println("1. View Loan Details");
            System.out.println("2. Apply for Loan");
            System.out.println("3. Repay Loan");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder's name: ");
                    name = scanner.nextLine();
                    viewLoanDetails(accounts, name);
                    break;

                case 2:
                    System.out.print("Enter account holder's name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter loan amount to apply: ");
                    double applyAmount = scanner.nextDouble();
                    applyLoan(accounts, name, applyAmount);
                    break;

                case 3:
                    System.out.print("Enter account holder's name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter amount to repay: ");
                    double repayAmount = scanner.nextDouble();
                    repayLoan(accounts, name, repayAmount);
                    break;

                case 4:
                    System.out.println("Exiting Loan System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    // View loan amount
    public static void viewLoanDetails(List<Account> accounts, String name) {
        for (Account acc : accounts) {
            if (acc.name.equalsIgnoreCase(name)) {
                System.out.println("Loan for " + acc.name + ": ₹" + acc.loanAmount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    // Apply for loan
    public static void applyLoan(List<Account> accounts, String name, double amount) {
        for (Account acc : accounts) {
            if (acc.name.equalsIgnoreCase(name)) {
                acc.loanAmount += amount;
                System.out.println("Loan applied successfully. New loan amount: ₹" + acc.loanAmount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    // Repay loan
    public static void repayLoan(List<Account> accounts, String name, double amount) {
        for (Account acc : accounts) {
            if (acc.name.equalsIgnoreCase(name)) {
                if (amount <= acc.loanAmount) {
                    acc.loanAmount -= amount;
                    System.out.println("Repayment successful. Remaining loan: ₹" + acc.loanAmount);
                } else {
                    System.out.println("Repayment amount exceeds current loan.");
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }
}