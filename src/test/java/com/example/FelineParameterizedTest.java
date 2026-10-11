package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

// Параметризованные тесты по требованию вынесены в отдельный класс.
// Раннер Parameterized запускает каждый тест для каждого набора данных.
@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;

    // Значение из набора данных приходит в конструктор
    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    // name — как будет подписан каждый запуск в отчёте IDEA
    @Parameterized.Parameters(name = "Количество котят: {0}")
    public static Object[][] getKittensData() {
        return new Object[][]{
                {0},
                {1},
                {5},
        };
    }

    @Test
    public void getKittensWithArgReturnsSameCount() {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
