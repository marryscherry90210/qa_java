package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// Дополнительное задание: тесты на льва Алекса
@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    // Мок зависимости: Feline передаётся в Alex через конструктор
    @Mock
    Feline feline;

    private Alex alex;

    // Общая инициализация для всех тестов. MockitoJUnitRunner создаёт моки
    // до вызова методов с @Before, поэтому feline здесь уже готов
    @Before
    public void setUp() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    public void getFriendsReturnsMadagascarFriends() {
        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsNewYorkZoo() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZero() {
        assertEquals(0, alex.getKittens());
    }

    // Конструктор всегда передаёт "Самец" → у Алекса должна быть грива
    @Test
    public void alexHasMane() {
        assertTrue(alex.doesHaveMane());
    }
}
