package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    // Мок Feline: тестируем только Cat, а поведение Feline задаём сами
    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        // Стаб: когда Cat вызовет feline.eatMeat(), мок вернёт expected
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        Cat cat = new Cat(feline);
        assertEquals(expected, cat.getFood());
    }

    @Test
    public void getFoodCallsEatMeat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        // Cat должен получать еду через Feline.eatMeat()
        Mockito.verify(feline).eatMeat();
    }
}
