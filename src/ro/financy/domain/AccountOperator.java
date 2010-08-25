package ro.financy.domain;

import ro.financy.domain.transactions.Transaction;

/**
 * Created by IntelliJ IDEA.
 * User: MacPro
 * Date: Jul 3, 2010
 * Time: 11:45:50 AM
 */
final class AccountOperator {

    private AccountOperator() {

    }

    static Amount addTransaction(Amount currentAmount, Transaction tx) {

        switch (tx.getType()) {
            case EXPENSE:
                return currentAmount.substract(tx.getAmount());
            case INCOME:
                return currentAmount.add(tx.getAmount());
            default:
                throw new IllegalStateException("Programming error! No amount defined");
        }

    }

}
