 package BankService.loan;

public class PremiumLoan implements Loan {
    private double interestRate = 12;
    @Override
    public double calculateInterest(double amount, int year) {
        return (amount*year*interestRate)/100;
    }
    
}
