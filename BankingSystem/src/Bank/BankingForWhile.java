public class BankTransactions {
    public static void main(String[] args) {
        // Sample account balances for multiple customers
        double[] accountBalances = {1500.0, 2500.0, 3500.0, 4500.0, 5500.0};
        double interestRate = 0.05; // 5% annual interest rate
        int months = 12;

        // Using for loop to calculate and display compound interest for each account
        System.out.println("Compound Interest Calculation for Each Account:");
        for (int i = 0; i < accountBalances.length; i++) {
            double principal = accountBalances[i];
            double amount = principal;
            
            // Calculate compound interest monthly
            for (int month = 1; month <= months; month++) {
                amount = amount * (1 + (interestRate / 12));
            }
            
            System.out.printf("Account %d: Initial Balance: $%.2f, After one year: $%.2f, Profit: $%.2f%n", 
                            i + 1, principal, amount, (amount - principal));
        }

        // Using while loop to process transactions until daily limit is reached
        System.out.println("\nProcessing Daily Transactions:");
        double dailyTransactionLimit = 10000.0;
        double totalTransactions = 0.0;
        double[] transactions = {2000.0, 1500.0, 3000.0, 2500.0, 1000.0};
        int transactionIndex = 0;

        while (transactionIndex < transactions.length && 
               totalTransactions + transactions[transactionIndex] <= dailyTransactionLimit) {
            totalTransactions += transactions[transactionIndex];
            System.out.printf("Transaction %d: $%.2f, Total for day: $%.2f%n", 
                            transactionIndex + 1, transactions[transactionIndex], totalTransactions);
            transactionIndex++;
        }

        if (transactionIndex < transactions.length) {
            System.out.println("Daily transaction limit reached. Remaining transactions cancelled.");
        }

        // Using nested loops to analyze monthly spending patterns
        System.out.println("\nMonthly Spending Analysis:");
        double[][] monthlyTransactions = {
            {1000.0, 1500.0, 2000.0, 1700.0}, // Week 1-4 for Month 1
            {1200.0, 1600.0, 1800.0, 2100.0}, // Week 1-4 for Month 2
            {1400.0, 1900.0, 2200.0, 1500.0}  // Week 1-4 for Month 3
        };

        for (int month = 0; month < monthlyTransactions.length; month++) {
            double monthlyTotal = 0.0;
            System.out.printf("\nMonth %d weekly transactions:%n", month + 1);
            
            for (int week = 0; week < monthlyTransactions[month].length; week++) {
                double weeklyAmount = monthlyTransactions[month][week];
                monthlyTotal += weeklyAmount;
                System.out.printf("Week %d: $%.2f%n", week + 1, weeklyAmount);
            }
            
            System.out.printf("Month %d Total: $%.2f%n", month + 1, monthlyTotal);
        }

        // Using do-while loop to calculate minimum payments for a loan
        System.out.println("\nLoan Payment Schedule:");
        double loanAmount = 10000.0;
        double annualInterestRate = 0.08; // 8% APR
        double monthlyPayment = 500.0;
        int paymentCount = 0;
        double remainingBalance = loanAmount;

        do {
            double monthlyInterest = remainingBalance * (annualInterestRate / 12);
            remainingBalance = remainingBalance + monthlyInterest - monthlyPayment;
            paymentCount++;
            
            System.out.printf("Payment %d: Interest: $%.2f, Remaining Balance: $%.2f%n", 
                            paymentCount, monthlyInterest, remainingBalance);
                            
        } while (remainingBalance > 0 && paymentCount < 36); // Maximum 3 years of payments

        if (remainingBalance > 0) {
            System.out.println("Loan will not be fully paid with current payment schedule.");
        } else {
            System.out.printf("Loan will be paid off in %d months%n", paymentCount);
        }
    }
}