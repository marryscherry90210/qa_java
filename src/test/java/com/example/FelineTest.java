package com.example;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

// Feline — тестируемый объект, поэтому используем настоящий экземпляр, без моков и шпионов.
// У Feline нет внешних зависимостей, которые нужно было бы подменять.
public class FelineTest {

    private Feline feline;

    // Создаём новый объект перед каждым тестом, чтобы тесты не влияли друг на друга
    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    // Метод без аргументов должен вернуть 1 котёнка (внутри вызывается getKittens(1))
    @Test
    public void getKittensWithoutArgsReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    // getKittens(int) с разными значениями проверяется в FelineParameterizedTest
}
