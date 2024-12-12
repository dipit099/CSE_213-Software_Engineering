package BankService.factory;
import BankService.account.*;
import BankService.loan.*;

public class VIPServiceFactory implements BankServiceFactory {
    @Override
    public Account createAccount() {
        return new VIPAccount();
    }

    @Override
    public Loan createLoan() {
        return new VIPLoan();
    }
   
}
