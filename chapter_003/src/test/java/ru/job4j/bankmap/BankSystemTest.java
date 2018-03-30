package ru.job4j.bankmap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankSystemTest {

    @Test
    public void whenWeTransferMoney() {
        BankSystem bank = new BankSystem();
        bank.addUser(new User("Roman", "45AB"));
        bank.addUser(new User("Nikolai", "50CD"));
        bank.addUser(new User("Igor", "55EF"));
        bank.addAccountToUser("45AB", new Account(1000.50, "source1"));
        bank.addAccountToUser("45AB", new Account(630, "second_source1"));
        bank.addAccountToUser("50CD", new Account(750, "source2"));
        bank.addAccountToUser("55EF", new Account(140.60, "source3"));
        boolean result = bank.transferMoney("45AB", "source1", "55EF", "source3", 300);
        assertThat(result, is(true));
        assertThat(bank.getAccountFromList("45AB", "source1").getValue(), is(700.50));
    }
}
