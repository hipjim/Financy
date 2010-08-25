package ro.financy.domain.transactions;

import ro.financy.domain.Amount;

/**
 * Created by IntelliJ IDEA.
 * User: cristian.popovici
 * Date: Aug 25, 2010
 * Time: 9:58:10 AM
 */
public class IncomeTransaction extends Transaction {

    public IncomeTransaction(Amount amount) {
        super(TransactionType.INCOME, amount);
    }

}
