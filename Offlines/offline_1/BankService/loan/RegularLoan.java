package BankService.loan;

public class RegularLoan implements Loan{
    private double interestRate = 14;
    @Override
    public double calculateInterest(double amount, int year) {
        return (amount*year*interestRate)/100;
    }

    
}
