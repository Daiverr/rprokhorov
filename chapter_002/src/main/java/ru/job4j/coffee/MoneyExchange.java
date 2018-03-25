package ru.job4j.coffee;

public class MoneyExchange {

    public int[] changes(int value, int price) {
        int change = value - price;

        int ten = change / 10;
        int five = (change % 10) / 5;
        int two = (change % 5) / 2;
        int one = change - ten*10 - five*5 - two*2;

        int[] result = new int[ten + five + two + one];

        System.arraycopy(this.add(10, ten), 0, result,0, ten);
        System.arraycopy(this.add(5, five), 0, result, ten, five);
        System.arraycopy(this.add(2, two), 0, result, ten + five, two);
        System.arraycopy(this.add(1, one), 0, result, ten + five + two, one);

        return result;
    }

    private int[] add(int coin, int numb) {
        int[] result = new int[numb];
        for (int i = 0; i < numb; i++){
            result[i] = coin;
        }
        return result;

    }

}

//50, 100, 500, 1000
//1, 2, 5, 10