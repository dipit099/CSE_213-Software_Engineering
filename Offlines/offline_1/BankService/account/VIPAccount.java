package BankService.account;

public class VIPAccount implements Account{
    private double interestRate = 5;


    @Override
    public double calculateInterest(double amount, int year) {
        return (amount*year*interestRate)/1000;
    }
    
}
