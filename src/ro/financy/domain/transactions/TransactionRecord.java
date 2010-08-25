package ro.financy.domain.transactions;

import ro.financy.domain.Tag;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: MacPro
 * Date: Jul 2, 2010
 */
public final class TransactionRecord {

    private final Set<Transaction> incomes;

    private final Set<Transaction> expenses;

    private final Map<TransactionType, Set<Transaction>> transactionMap;

    private final Map<TransactionDate, List<Transaction>> indexDate =
            new HashMap<TransactionDate, List<Transaction>>();

    public TransactionRecord() {
        incomes = new LinkedHashSet<Transaction>();
        expenses = new LinkedHashSet<Transaction>();

        transactionMap = new HashMap<TransactionType, Set<Transaction>>();
        transactionMap.put(TransactionType.INCOME, incomes);
        transactionMap.put(TransactionType.EXPENSE, expenses);
    }


    public Set<Transaction> getTransactionSet(TransactionType type) {
        return transactionMap.get(type);
    }

    public void record(final Transaction tx) {
        transactionMap.get(tx.getType()).add(tx);

        TransactionDate txDate = TransactionDate.now();
        List<Transaction> trx = indexDate.get(txDate);

        if (trx != null) {
            trx.add(tx);
            return;
        }

        trx = new ArrayList<Transaction>();
        trx.add(tx);

        indexDate.put(txDate, trx);
    }


    public Set getIncomeTransactionsTaggedWith(Tag tag) {
        Set<Transaction> transactions = new HashSet<Transaction>();

        for (Transaction tx : incomes) {
            if (tx.getTags().contains(tag)) {
                transactions.add(tx);
            }
        }

        return transactions;
    }

    public Set getExpenseTransactionsTaggedWith(Tag tag) {
        Set<Transaction> transactions = new HashSet<Transaction>();

        for (Transaction tx : expenses) {
            if (tx.getTags().contains(tag)) {
                transactions.add(tx);
            }
        }

        return transactions;
    }


}
