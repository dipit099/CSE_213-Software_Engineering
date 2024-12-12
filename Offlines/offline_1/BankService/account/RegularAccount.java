package BankService.account;

public class RegularAccount implements Account {
    private double interestRate = 2.5;


    @Override
    public double calculateInterest(double amount, int year) {
        return (amount*year*interestRate)/1000;
    }
    
}
