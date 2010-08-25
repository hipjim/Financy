package ro.financy.domain.transactions;

import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: MacPro
 * Date: Jul 3, 2010
 */
final class TransactionDate {

    private final Date date;

    private TransactionDate() {
        this.date = new Date();
    }

    private TransactionDate(final Date date) {
        this.date = date;
    }

    static TransactionDate now() {
        return new TransactionDate();
    }

    static TransactionDate create(final Date date) {
        return new TransactionDate(date);
    }

    public Date getDate() {
        return date;
    }

    public boolean isSameDay(TransactionDate other) {
        return DateUtils.isSameDay(date, other.getDate());
    }
}
