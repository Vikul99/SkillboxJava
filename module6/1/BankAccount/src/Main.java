import Accounts.CheckAccount;
import Accounts.CreditAccount;
import Accounts.DepositAccount;
import Accounts.MyTime;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount();
        System.out.println("Баланс расчетного счета: " + checkAccount.getBalance());
        checkAccount.addMoney(2500.0);
        System.out.println("Баланс расчетного счета: " + checkAccount.getBalance());
        checkAccount.getMoney(1000.0);
        System.out.println("Баланс расчетного счета: " + checkAccount.getBalance());

        DepositAccount depositAccount = new DepositAccount();
        System.out.println("Баланс депозитного счета: " + depositAccount.getBalance());
        depositAccount.addMoney(10000.0);
        System.out.println("Баланс депозитного счета: " + depositAccount.getBalance());
        MyTime.getInstance().setNow(LocalDate.now().plusDays(32));
        depositAccount.getMoney(3000.0);
        System.out.println("Баланс депозитного счета: " + depositAccount.getBalance());

        CreditAccount creditAccount = new CreditAccount(1000000.0);
        System.out.println("Баланс кредитного счета: " + creditAccount.getBalance());
        creditAccount.getMoney(500000);
        System.out.println("Баланс кредитного счета: " + creditAccount.getBalance());

        creditAccount.transfer(depositAccount, 100000.00);
        System.out.println("Баланс депозитного счета: " + depositAccount.getBalance());
        System.out.println("Баланс кредитного счета: " + creditAccount.getBalance());

        var deposit = new DepositAccount(2000.0);
        var myAccount = new CheckAccount(0);
        MyTime.getInstance().setNow(LocalDate.now().plusDays(32));
        depositAccount.transfer(myAccount, 1000.0);
        System.out.println(myAccount.getBalance());
    }
}
