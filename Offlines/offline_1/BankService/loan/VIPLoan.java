package BankService.loan;

public class VIPLoan implements Loan{
    private double interestRate = 10;
    @Override
    public double calculateInterest(double amount, int year) {
        return (amount*year*interestRate)/100;
    }

    
}
