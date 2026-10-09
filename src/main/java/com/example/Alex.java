package com.example;

import java.util.List;

// Дополнительное задание: лев Алекс из «Мадагаскара», наследник Lion.
public class Alex extends Lion {

    // Алекс — самец, поэтому пол всегда "Самец". Feline по-прежнему внедряем снаружи,
    // чтобы в тестах можно было подставить мок.
    public Alex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    // У Алекса нет львят — переопределяем метод родителя
    @Override
    public int getKittens() {
        return 0;
    }
}
