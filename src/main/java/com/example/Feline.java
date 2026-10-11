package com.example;

import java.util.List;

// Класс из заготовки — не меняем. Покрываем тестами на 100%.
public class Feline extends Animal implements Predator {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    // Без аргумента — делегирует в перегруженный метод со значением 1
    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}
