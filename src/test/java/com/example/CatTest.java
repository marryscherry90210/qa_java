package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    // Мок зависимости Feline: тестируем только Cat, а поведение Feline задаём сами
    @Mock
    Feline feline;

    private Cat cat;

    // Общая инициализация тестируемого объекта для всех тестов
    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        // Стаб: когда Cat вызовет feline.eatMeat(), мок вернёт expected
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        assertEquals(expected, cat.getFood());
    }

    @Test
    public void getFoodCallsEatMeat() throws Exception {
        cat.getFood();
        // Cat должен получать еду через зависимость — Feline.eatMeat()
        Mockito.verify(feline).eatMeat();
    }
}
