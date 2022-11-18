package ru.yandex.practicum;

public class Account {

    private final String name;
    private final int oneNumberCount = 3;
    private final int twoNumberCount = 19;
    private int count = 0;
    private boolean getBoolean;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */

        for(int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                count = count + 1;
            }
        }

        if (count == 1) {
            getBoolean = true;
        }

        if (name.length() >= oneNumberCount && name.length() <= twoNumberCount
                && !name.startsWith(" ")
                && !name.endsWith(" ")
                && getBoolean) {
            System.out.println("Имя введено корректно: " + name);
            return true;
        } else {
            System.out.println("Имя введено некорректно. Пожалуйста введите корректное имя");
            return false;
        }

    }
}