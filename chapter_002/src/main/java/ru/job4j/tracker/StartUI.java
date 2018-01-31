package ru.job4j.tracker;
/**
 * StartUI.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {

    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        boolean exit = false;
        menu.fillActions();
        do {
            menu.showMenu();
            int answer = Integer.valueOf(this.input.ask("Введите пункт меню : "));
            menu.select(answer);
        } while (!"Да".equals(this.input.ask("Выйти? <Да>")));
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

