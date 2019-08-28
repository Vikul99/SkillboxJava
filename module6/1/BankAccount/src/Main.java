import Accounts.CheckAccount;
import Accounts.CreditAccount;
import Accounts.DepositAccount;

import java.time.LocalDate;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount();
        System.out.println("Баланс расчетного счета: " + checkAccount.getMoneyAmount());
        checkAccount.addMoney(2500.0);
        System.out.println("Баланс расчетного счета: " + checkAccount.getMoneyAmount());
        checkAccount.getMoney(1000.0);
        System.out.println("Баланс расчетного счета: " + checkAccount.getMoneyAmount());

        DepositAccount depositAccount = new DepositAccount();
        System.out.println("Баланс депозитного счета: " + depositAccount.getMoneyAmount());
        LocalDate date = LocalDate.now();
        depositAccount.getMoney(25000.0, date);
        System.out.println("Баланс депозитного счета: " + depositAccount.getMoneyAmount());
        depositAccount.addMoney(5000.0);
        System.out.println("Баланс депозитного счета: " + depositAccount.getMoneyAmount());
        date = date.plusWeeks(5);
        depositAccount.getMoney(3000.0, date);
        System.out.println("Баланс депозитного счета: " + depositAccount.getMoneyAmount());

        CreditAccount creditAccount = new CreditAccount(1000000.0);
        System.out.println("Баланс кредитного счета: " + creditAccount.getMoneyAmount());
        creditAccount.getMoney(500000);
        System.out.println("Баланс кредитного счета: " + creditAccount.getMoneyAmount());

        creditAccount.transfer(depositAccount, 100000.0);
        System.out.println("Баланс депозитного счета: " + depositAccount.getMoneyAmount());
        System.out.println("Баланс кредитного счета: " + creditAccount.getMoneyAmount());

        var deposit = new DepositAccount(2000.0);
        var myAccount = new CheckAccount(0);
        date = LocalDate.now();
        date = date.plusDays(3);
        depositAccount.transfer(myAccount, 1000.0, date);
        System.out.println(myAccount.getMoneyAmount());
    }
}
