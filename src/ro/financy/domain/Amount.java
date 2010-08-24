package ro.financy.domain;

import java.math.BigDecimal;
import java.util.Currency;

public final class Amount extends DomainObject {
    
    private final BigDecimal amount;
    private final Currency currency;

    private Amount(final Currency currency) {
        this.currency = currency;
        this.amount = BigDecimal.ZERO;
    }

    private Amount(final Currency currency, final BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Amount newAmount(final Currency currency) {
        return new Amount(currency);
    }

    public static Amount newAmount(final Currency currency, final BigDecimal initialAmount) {
        return new Amount(currency, initialAmount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Amount add(Amount amount) {
        return new Amount(this.currency,
                this.amount.add(amount.getAmount()));
    }

    public Amount substract(Amount amount) {
        return new Amount(this.currency,
                this.amount.subtract(amount.getAmount()));
    }


    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }

        if (!(o instanceof Amount)) {
            return -1;
        }

        if (!currency.equals((Amount)o)) {
            return -1;
        }

        return amount.compareTo(((Amount)o).getAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount1 = (Amount) o;

        if (amount != null ? !amount.equals(amount1.amount) : amount1.amount != null) return false;
        if (currency != null ? !currency.equals(amount1.currency) : amount1.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
