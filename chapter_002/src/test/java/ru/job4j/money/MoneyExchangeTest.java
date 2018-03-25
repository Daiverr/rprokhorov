package ru.job4j.money;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.job4j.coffee.MoneyExchange;

public class MoneyExchangeTest {

    @Test
    public void CoffeeFor35() {
        MoneyExchange moneyExchange = new MoneyExchange();
        int[] result = moneyExchange.changes(50, 35);
        int[] exp = {10, 5};
        assertThat(result, is(exp));
    }

    @Test
    public void CoffeeFor19() {
        MoneyExchange moneyExchange = new MoneyExchange();
        int[] result = moneyExchange.changes(50, 19);
        int[] exp = {10, 10, 10, 1};
        assertThat(result, is(exp));
    }
}
