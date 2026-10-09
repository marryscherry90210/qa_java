package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

// MockitoJUnitRunner инициализирует поля с аннотациями @Mock / @Spy
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    // Spy — настоящий объект Feline, но Mockito следит за вызовами его методов.
    // Нужен, чтобы проверить, что eatMeat() и getKittens() вызывают нужные методы внутри.
    @Spy
    Feline feline;

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void eatMeatCallsGetFoodWithPredator() throws Exception {
        feline.eatMeat();
        // Проверяем, что внутри eatMeat() вызван getFood("Хищник") ровно один раз
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnsFeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgsReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithoutArgsCallsGetKittensWithOne() {
        feline.getKittens();
        // Метод без аргументов должен делегировать в getKittens(1)
        Mockito.verify(feline).getKittens(1);
    }

    // getKittens(int) с разными значениями проверяется в FelineParameterizedTest
}
