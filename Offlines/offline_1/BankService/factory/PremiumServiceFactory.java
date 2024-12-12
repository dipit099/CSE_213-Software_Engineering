package BankService.factory;

import BankService.account.*;
import BankService.loan.*;

public class PremiumServiceFactory implements BankServiceFactory {
    @Override
    public Account createAccount() {
        return new PremiumAccount();
    }

    @Override
    public Loan createLoan() {
        return new PremiumLoan();
    }

}
