package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;

    // БЫЛО в заготовке: Feline feline = new Feline();
    // Lion сам создавал объект Feline — это жёсткая зависимость, мок туда не подставить.
    // СТАЛО: Feline приходит снаружи через конструктор (инъекция зависимости).
    private final Feline feline;

    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;
        // Три ветки условия → в тестах нужны: "Самец", "Самка" (параметризованный тест)
        // и некорректное значение (отдельный тест на исключение)
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
