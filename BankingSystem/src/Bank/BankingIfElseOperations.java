public class BankingOperations {
    public static void main(String[] args) {
        // Sample account details
        double accountBalance = 5000.0;
        double withdrawalAmount = 2000.0;
        int creditScore = 750;
        double monthlyIncome = 5000.0;
        boolean hasExistingLoan = false;

        // Check account balance and withdrawal
        if (withdrawalAmount > accountBalance) {
            System.out.println("Insufficient funds. Your balance is: $" + accountBalance);
        } else {
            accountBalance -= withdrawalAmount;
            System.out.println("Withdrawal successful. Remaining balance: $" + accountBalance);
        }

        // Check account status based on balance
        if (accountBalance < 1000) {
            System.out.println("Warning: Low balance!");
        } else if (accountBalance < 3000) {
            System.out.println("Balance is moderate.");
        } else {
            System.out.println("Balance is good.");
        }

        // Loan eligibility check
        if (creditScore >= 700 && monthlyIncome >= 3000 && !hasExistingLoan) {
            System.out.println("Congratulations! You are eligible for a loan.");
            
            // Determine loan amount based on monthly income
            if (monthlyIncome >= 5000) {
                System.out.println("You can apply for a loan up to $50,000");
            } else if (monthlyIncome >= 4000) {
                System.out.println("You can apply for a loan up to $40,000");
            } else {
                System.out.println("You can apply for a loan up to $30,000");
            }
        } else {
            System.out.println("Sorry, you are not eligible for a loan at this time.");
            
            // Provide specific reason for loan rejection
            if (creditScore < 700) {
                System.out.println("Reason: Credit score is too low");
            }
            if (monthlyIncome < 3000) {
                System.out.println("Reason: Monthly income is below minimum requirement");
            }
            if (hasExistingLoan) {
                System.out.println("Reason: You already have an existing loan");
            }
        }

        // Interest rate determination based on account balance
        double interestRate;
        if (accountBalance >= 10000) {
            interestRate = 3.5;
        } else if (accountBalance >= 5000) {
            interestRate = 3.0;
        } else if (accountBalance >= 1000) {
            interestRate = 2.5;
        } else {
            interestRate = 2.0;
        }
        System.out.println("Your account's interest rate is: " + interestRate + "%");
    }
}