package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value =  this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Неверно. Укажите значение от 0 до 6");
            } catch (NumberFormatException nfe) {
                System.out.println("Неверно. Укажите значение от 0 до 6");
            }
        } while (invalid);
        return value;
    }
}
