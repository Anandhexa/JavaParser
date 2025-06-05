import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FinancialCalculations {
    // Constants for calculations
    private static final DecimalFormat df = new DecimalFormat("#.##");
    private static final double TAX_RATE = 0.20; // 20% tax rate
    private static final double INFLATION_RATE = 0.03; // 3% annual inflation

    public static void main(String[] args) {
        // Demonstrate various calculations
        System.out.println("=== Financial Calculations Demo ===\n");

        // Simple Interest Calculation
        calculateSimpleInterest(10000, 0.05, 5);

        // Compound Interest Calculation
        calculateCompoundInterest(10000, 0.06, 10);

        // Loan EMI Calculation
        calculateLoanEMI(100000, 0.08, 5);

        // Investment Portfolio Return
        calculatePortfolioReturn();

        // Retirement Planning Calculation
        retirementPlanning(35, 65, 5000, 0.07);

        // Tax Calculations
        calculateTaxes(75000);

        // Mortgage Calculations
        calculateMortgage(300000, 0.045, 30);

        // Investment Growth with Regular Deposits
        calculateInvestmentGrowth(1000, 500, 0.08, 20);

        // Present Value Calculation
        calculatePresentValue(50000, 0.05, 10);

        // Future Value with Inflation Adjustment
        calculateInflationAdjustedValue(10000, 20);
    }

    // Calculate Simple Interest
    private static void calculateSimpleInterest(double principal, double rate, int years) {
        double interest = principal * rate * years;
        double amount = principal + interest;
        
        System.out.println("Simple Interest Calculation:");
        System.out.println("Principal: $" + principal);
        System.out.println("Interest Rate: " + (rate * 100) + "%");
        System.out.println("Time Period: " + years + " years");
        System.out.println("Interest Earned: $" + df.format(interest));
        System.out.println("Final Amount: $" + df.format(amount) + "\n");
    }

    // Calculate Compound Interest
    private static void calculateCompoundInterest(double principal, double rate, int years) {
        double amount = principal * Math.pow(1 + rate, years);
        double interest = amount - principal;
        
        System.out.println("Compound Interest Calculation:");
        System.out.println("Principal: $" + principal);
        System.out.println("Interest Rate: " + (rate * 100) + "%");
        System.out.println("Time Period: " + years + " years");
        System.out.println("Interest Earned: $" + df.format(interest));
        System.out.println("Final Amount: $" + df.format(amount) + "\n");
    }

    // Calculate Loan EMI (Equated Monthly Installment)
    private static void calculateLoanEMI(double principal, double annualRate, int years) {
        double monthlyRate = annualRate / 12;
        int months = years * 12;
        
        double emi = principal * monthlyRate * Math.pow(1 + monthlyRate, months) 
                    / (Math.pow(1 + monthlyRate, months) - 1);
        
        System.out.println("Loan EMI Calculation:");
        System.out.println("Loan Amount: $" + principal);
        System.out.println("Annual Interest Rate: " + (annualRate * 100) + "%");
        System.out.println("Loan Term: " + years + " years");
        System.out.println("Monthly EMI: $" + df.format(emi));
        System.out.println("Total Payment: $" + df.format(emi * months) + "\n");
    }

    // Calculate Investment Portfolio Return
    private static void calculatePortfolioReturn() {
        // Sample portfolio with different investments and their returns
        double[] investments = {20000, 30000, 50000};
        double[] returns = {0.08, 0.06, 0.09}; // 8%, 6%, 9% returns
        
        double totalInvestment = 0;
        double totalReturn = 0;
        
        for (int i = 0; i < investments.length; i++) {
            totalInvestment += investments[i];
            totalReturn += investments[i] * returns[i];
        }
        
        double portfolioReturn = (totalReturn / totalInvestment) * 100;
        
        System.out.println("Portfolio Return Calculation:");
        System.out.println("Total Investment: $" + df.format(totalInvestment));
        System.out.println("Total Return: $" + df.format(totalReturn));
        System.out.println("Portfolio Return Rate: " + df.format(portfolioReturn) + "%\n");
    }

    // Calculate Retirement Planning
    private static void retirementPlanning(int currentAge, int retirementAge, 
                                         double monthlyContribution, double expectedReturn) {
        int years = retirementAge - currentAge;
        double monthlyRate = expectedReturn / 12;
        int months = years * 12;
        
        double futureValue = monthlyContribution * 
                            ((Math.pow(1 + monthlyRate, months) - 1) / monthlyRate);
        
        System.out.println("Retirement Planning Calculation:");
        System.out.println("Monthly Contribution: $" + monthlyContribution);
        System.out.println("Expected Annual Return: " + (expectedReturn * 100) + "%");
        System.out.println("Years until Retirement: " + years);
        System.out.println("Expected Retirement Savings: $" + df.format(futureValue) + "\n");
    }

    // Calculate Taxes
    private static void calculateTaxes(double income) {
        double taxAmount = income * TAX_RATE;
        double netIncome = income - taxAmount;
        
        System.out.println("Tax Calculation:");
        System.out.println("Gross Income: $" + df.format(income));
        System.out.println("Tax Rate: " + (TAX_RATE * 100) + "%");
        System.out.println("Tax Amount: $" + df.format(taxAmount));
        System.out.println("Net Income: $" + df.format(netIncome) + "\n");
    }

    // Calculate Mortgage
    private static void calculateMortgage(double principal, double annualRate, int years) {
        double monthlyRate = annualRate / 12;
        int months = years * 12;
        
        double monthlyPayment = principal * 
                              (monthlyRate * Math.pow(1 + monthlyRate, months)) /
                              (Math.pow(1 + monthlyRate, months) - 1);
        
        System.out.println("Mortgage Calculation:");
        System.out.println("Principal Amount: $" + df.format(principal));
        System.out.println("Annual Interest Rate: " + (annualRate * 100) + "%");
        System.out.println("Term: " + years + " years");
        System.out.println("Monthly Payment: $" + df.format(monthlyPayment));
        System.out.println("Total Payment: $" + df.format(monthlyPayment * months) + "\n");
    }

    // Calculate Investment Growth with Regular Deposits
    private static void calculateInvestmentGrowth(double initialAmount, 
                                                double monthlyDeposit, 
                                                double annualRate, 
                                                int years) {
        double monthlyRate = annualRate / 12;
        int months = years * 12;
        
        double futureValue = initialAmount * Math.pow(1 + monthlyRate, months) +
                           monthlyDeposit * ((Math.pow(1 + monthlyRate, months) - 1) / monthlyRate);
        
        System.out.println("Investment Growth Calculation:");
        System.out.println("Initial Amount: $" + df.format(initialAmount));
        System.out.println("Monthly Deposit: $" + df.format(monthlyDeposit));
        System.out.println("Annual Return Rate: " + (annualRate * 100) + "%");
        System.out.println("Investment Period: " + years + " years");
        System.out.println("Future Value: $" + df.format(futureValue) + "\n");
    }

    // Calculate Present Value
    private static void calculatePresentValue(double futureValue, double rate, int years) {
        double presentValue = futureValue / Math.pow(1 + rate, years);
        
        System.out.println("Present Value Calculation:");
        System.out.println("Future Value: $" + df.format(futureValue));
        System.out.println("Interest Rate: " + (rate * 100) + "%");
        System.out.println("Time Period: " + years + " years");
        System.out.println("Present Value: $" + df.format(presentValue) + "\n");
    }

    // Calculate Inflation Adjusted Value
    private static void calculateInflationAdjustedValue(double currentAmount, int years) {
        double futureValue = currentAmount / Math.pow(1 + INFLATION_RATE, years);
        
        System.out.println("Inflation Adjusted Value Calculation:");
        System.out.println("Current Amount: $" + df.format(currentAmount));
        System.out.println("Inflation Rate: " + (INFLATION_RATE * 100) + "%");
        System.out.println("Time Period: " + years + " years");
        System.out.println("Inflation Adjusted Value: $" + df.format(futureValue) + "\n");
    }
}