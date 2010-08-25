package ro.financy.domain.transactions;

import ro.financy.domain.Amount;
import ro.financy.domain.DomainObject;
import ro.financy.domain.Tag;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: MacPro
 * Date: Jul 2, 2010
 */
public abstract class Transaction extends DomainObject {

    private final Amount amount;
    private final TransactionType type;
    private final Date time;

    private Set<Tag> tagSet = new HashSet<Tag>();

    public Transaction(TransactionType type, Amount amount) {
        this.type = type;
        this.amount = amount;
        this.time = new Date();
    }

    public Amount getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public Date getTime() {
        return time;
    }

    public void addTag(Tag tag) {
        tagSet.add(tag);
    }

    public Set getTags() {
        return tagSet;
    }

}
