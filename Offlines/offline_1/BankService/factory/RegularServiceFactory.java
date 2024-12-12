package BankService.factory;
import BankService.account.*;
import BankService.loan.*;

public class RegularServiceFactory implements BankServiceFactory{
    @Override
    public Account createAccount() {
        return new RegularAccount();
    }
    @Override
    public Loan createLoan() {
        return new RegularLoan();
    }
   
}
