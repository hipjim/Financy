package ro.financy.domain.user;

import org.apache.commons.validator.EmailValidator;
import ro.financy.domain.Account;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: cristian.popovici
 * Date: Aug 25, 2010
 * Time: 12:24:59 PM
 */
public class User {

    private final String emailAddress;
    private String name;
    private Set<Account> accountList;

    public User(String emailAddress) {
        if (!EmailValidator.getInstance().isValid(emailAddress)) {
            throw new IllegalArgumentException("Invalid user email '" + emailAddress + "'");
        }
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public Set<Account> getAccountList() {
        return accountList;
    }

    public void setName(String name) {
        this.name = name;
    }
}