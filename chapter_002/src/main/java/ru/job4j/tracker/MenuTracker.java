package ru.job4j.tracker;


import java.util.ArrayList;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();
    protected ArrayList<Integer> ranges = new ArrayList<>();
    private int position = 0;


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions.add(this.new AddItem(0, "Создать заявку")); position++;
        this.actions.add(new MenuTracker.GetAll(1, "Показать все заявки"));position++;
        this.actions.add(new EditItem(2, "Редактировать заявку"));position++;
        this.actions.add(new DeleteItem(3, "Удалить заявку"));position++;
        this.actions.add(new FindById(4, "Поиск по ID"));position++;
        this.actions.add(new FindByName(5, "Поиск по имени"));position++;

        for (int i = 0; i < actions.size(); i++) {
            ranges.add(i);
        }
    }

    public void addAction(UserAction action) {
        this.actions.add(action);
        position++;
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);

    }

    public void showMenu() {
        System.out.println("Меню:");
        for (UserAction action: actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private class AddItem extends BaseAction {

        protected AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой языки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + " -----------");
        }
    }

    private static class GetAll extends BaseAction {

        protected GetAll(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item: tracker.getAll()) {
                System.out.println("Заявка: " + item.getId() + " " + item.getName());
            }
        }
    }
}

class EditItem extends BaseAction {

    protected EditItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID заявки для редактирования:");
        String name = input.ask("Введите новое имя заявки:");
        String desc = input.ask("Введите новое описание заявки:");
        long creat = System.currentTimeMillis();
        tracker.replace(id, new Item(name, desc, creat));
        System.out.println("------------ Заявка отредактирована ------------");
    }
}

class DeleteItem extends BaseAction {

    protected DeleteItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введие ID заявки для удаления:");
        tracker.delete(id);
        System.out.println("------------ Заявка удалена ------------");
    }
}

class FindById extends BaseAction {

    protected FindById(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введие ID заявки:");
        System.out.println(tracker.findById(id).getName());
        System.out.println(tracker.findById(id).getDesc());
    }
}

class FindByName extends BaseAction {

    protected FindByName(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введие имя заявки:");
        for (Item item: tracker.findByName(name)) {
            System.out.println("Заявка: " + item.getId() + " " + item.getName());
            System.out.println(item.getDesc());
        }
    }
}
