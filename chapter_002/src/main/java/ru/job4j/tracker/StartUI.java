package ru.job4j.tracker;
/**
 * StartUI.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {

    private static final String ADD = "0";
    private static final String GETALL = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (GETALL.equals(answer)) {
                this.getAll();
            } else if (REPLACE.equals(answer)) {
                this.replace();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
               this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else {
                System.out.println("Ошибка ввода. Укажите пункт меню от 0 до 6");
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + " -----------");
    }

    private void getAll() {
        for (Item item: this.tracker.getAll()) {
            System.out.println("Заявка: " + item.getId() + " " + item.getName());
        }
    }

    private void delete() {
        String id = this.input.ask("Введие ID заявки для удаления:");
        this.tracker.delete(id);
        System.out.println("------------ Заявка удалена ------------");
    }

    private void replace() {
        String id = this.input.ask("Введите ID заявки для редактирования:");
        String name = this.input.ask("Введите новое имя заявки:");
        String desc = this.input.ask("Введите новое описание заявки:");
        long creat = System.currentTimeMillis();
        this.tracker.replace(id, new Item(name, desc, creat));
        System.out.println("------------ Заявка отредактирована ------------");
    }

    private void findById() {
        String id = this.input.ask("Введие ID заявки:");
        System.out.println(this.tracker.findById(id).getName());
        System.out.println(this.tracker.findById(id).getDesc());
    }

    private void findByName() {
        String name = this.input.ask("Введие имя заявки:");
        for (Item item: this.tracker.findByName(name)) {
            System.out.println("Заявка: " + item.getId() + " " + item.getName());
            System.out.println(item.getDesc());
        }
    }

    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("0. Создать заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Поиск по ID");
        System.out.println("5. Поиск по имени");
        System.out.println("6. Выход из программы");

        // добавить остальные пункты меню.
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

