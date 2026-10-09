package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    // Благодаря инъекции зависимости передаём в Lion мок вместо настоящего Feline
    @Mock
    Feline feline;

    @Test
    public void getKittensReturnsFelineKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion("Самец", feline);
        assertEquals(expected, lion.getFood());
    }

    // Текст сообщения взят из заготовки как есть (включая опечатку «самей»).
    // Третья ветка конструктора — недопустимый пол. Ветки "Самец"/"Самка"
    // проверяются в LionParameterizedTest.
    @Test
    public void constructorWithInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Оно", feline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка",
                exception.getMessage());
    }
}
