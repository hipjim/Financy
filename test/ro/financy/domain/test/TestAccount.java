package ro.financy.domain.test;

import ro.financy.domain.Account;
import ro.financy.domain.Amount;
import ro.financy.domain.Tag;
import ro.financy.domain.transactions.ExpenseTransaction;
import ro.financy.domain.transactions.IncomeTransaction;
import ro.financy.domain.transactions.Transaction;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: MacPro
 * Date: Jul 3, 2010
 */

public class TestAccount {


    public static void main(String[] args) {

        final Currency curr = Currency.getInstance(new Locale("en", "gb"));

        final Account account = new Account("Cont'rol", curr);

        Transaction tx_1 = new IncomeTransaction(Amount.newAmount(curr, BigDecimal.valueOf(4000)));

        tx_1.addTag(new Tag("Salar"));
        tx_1.addTag(new Tag("Bonus"));

        Transaction tx_2 = new IncomeTransaction(Amount.newAmount(curr, BigDecimal.valueOf(3000)));

        Transaction tx_3 = new IncomeTransaction(Amount.newAmount(curr, BigDecimal.valueOf(0.14)));

        Transaction tx_4 = new ExpenseTransaction(Amount.newAmount(curr, BigDecimal.valueOf(3245.23)));

        tx_3.addTag(new Tag("Salar"));


        account.addTransaction(tx_1);
        account.addTransaction(tx_2);
        account.addTransaction(tx_3);
        account.addTransaction(tx_4);

        System.out.println(account.getCurrentAmount());

    }
}
