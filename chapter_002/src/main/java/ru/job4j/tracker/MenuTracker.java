package ru.job4j.tracker;



public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.GetAll();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
    }

    public void select(int key) {
        if (key >= 0 && key <= 5) {
            this.actions[key].execute(this.input, this.tracker);
        } else {
            System.out.println("Неверно. Укажите значение от 0 до 6");
        }
    }

    public void showMenu() {
        System.out.println("Меню:");
        for (UserAction action: actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой языки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + " -----------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Создать заявку");
        }
    }

    private static class GetAll implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item: tracker.getAll()) {
                System.out.println("Заявка: " + item.getId() + " " + item.getName());
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Показать все заявки");
        }
    }
}

class EditItem implements UserAction {

    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID заявки для редактирования:");
        String name = input.ask("Введите новое имя заявки:");
        String desc = input.ask("Введите новое описание заявки:");
        long creat = System.currentTimeMillis();
        tracker.replace(id, new Item(name, desc, creat));
        System.out.println("------------ Заявка отредактирована ------------");
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Редактировать заявку");
    }
}

class DeleteItem implements UserAction {

    public int key() {
        return 3;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введие ID заявки для удаления:");
        tracker.delete(id);
        System.out.println("------------ Заявка удалена ------------");
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Удалить заявку");
    }
}

class FindById implements UserAction {

    public int key() {
        return 4;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введие ID заявки:");
        System.out.println(tracker.findById(id).getName());
        System.out.println(tracker.findById(id).getDesc());
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Поиск по ID");
    }
}

class FindByName implements UserAction {

    public int key() {
        return 5;
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введие имя заявки:");
        for (Item item: tracker.findByName(name)) {
            System.out.println("Заявка: " + item.getId() + " " + item.getName());
            System.out.println(item.getDesc());
        }
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Поиск по имени");
    }
}
