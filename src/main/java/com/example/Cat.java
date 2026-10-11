package com.example;

import java.util.List;

// Класс из заготовки — не меняем. Feline уже передаётся через конструктор,
// поэтому в тестах вместо него легко подставить мок.
public class Cat {

    Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }

    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
