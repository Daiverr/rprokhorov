package ru.job4j.tracker;



public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];
    protected int[] ranges;
    private int position = 0;


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[position++] = this.new AddItem(0, "Создать заявку");
        this.actions[position++] = new MenuTracker.GetAll(1, "Показать все заявки");
        this.actions[position++] = new EditItem(2, "Редактировать заявку");
        this.actions[position++] = new DeleteItem(3, "Удалить заявку");
        this.actions[position++] = new FindById(4, "Поиск по ID");
        this.actions[position++] = new FindByName(5, "Поиск по имени");
        ranges = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            ranges[i] = i;
        }
    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);

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
