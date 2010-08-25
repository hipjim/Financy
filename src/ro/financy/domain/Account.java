package ro.financy.domain;

import ro.financy.domain.transactions.Transaction;
import ro.financy.domain.transactions.TransactionRecord;

import java.util.Currency;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: MacPro
 * Date: Jul 2, 2010
 */
public class Account extends DomainObject {

    private final String name;
    private final TransactionRecord transactionRecord;
    private Amount currentAmount;

    public Account(final String name, final Currency currency) {
        this.name = name;
        this.currentAmount = Amount.newAmount(currency);

        this.transactionRecord = new TransactionRecord();
    }


    public String getName() {
        return name;
    }

    public Currency getCurrency() {
        return currentAmount.getCurrency();
    }

    public Amount getCurrentAmount() {
        return currentAmount;
    }

    public void addTransaction(final Transaction tx) {
        currentAmount = AccountOperator.addTransaction(currentAmount, tx);
        transactionRecord.record(tx);
    }

    public Amount getMoneySpentOn(final Tag tag) {
        Set<Transaction> transactions = transactionRecord.getExpenseTransactionsTaggedWith(tag);
        Amount amount = Amount.newAmount(this.getCurrency());

        for (final Transaction tx : transactions) {
            amount = amount.add(tx.getAmount());
        }

        return amount;

    }

    public Amount getMoneyEarnedOn(final Tag tag) {
        Set<Transaction> transactions = transactionRecord.getIncomeTransactionsTaggedWith(tag);
        Amount amount = Amount.newAmount(this.getCurrency());

        for (final Transaction tx : transactions) {
            amount = amount.add(tx.getAmount());
        }

        return amount;

    }

}
