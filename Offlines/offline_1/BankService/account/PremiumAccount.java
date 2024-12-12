package BankService.account;


public class PremiumAccount implements Account {
    private double interestRate = 3.5;
    
    @Override
    public double calculateInterest(double amount, int year) {
        return (amount*year*interestRate)/1000;
    }

}
