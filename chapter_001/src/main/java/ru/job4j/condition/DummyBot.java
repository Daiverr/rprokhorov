package ru.job4j.condition;
/**
 * Point.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        if ("Привет, Бот.".equals(question)) {
            return "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            return "До скорой встречи.";
        } else {
            return "Это ставит меня в тупик. Спросите другой вопрос.";
        }
    }
}
