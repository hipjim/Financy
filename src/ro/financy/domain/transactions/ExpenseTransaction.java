package ro.financy.domain.transactions;

import ro.financy.domain.Amount;

/**
 * Created by IntelliJ IDEA.
 * User: cristian.popovici
 * Date: Aug 25, 2010
 * Time: 9:58:46 AM
 */
public class ExpenseTransaction extends Transaction {

    public ExpenseTransaction(Amount amount) {
        super(TransactionType.EXPENSE, amount);
    }
}
