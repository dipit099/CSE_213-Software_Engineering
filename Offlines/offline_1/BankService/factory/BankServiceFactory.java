package BankService.factory;
import BankService.account.Account;
import BankService.loan.Loan;

public interface BankServiceFactory {
    Account createAccount();
    Loan createLoan();
    
}
