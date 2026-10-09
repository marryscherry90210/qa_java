# qa_java
QA Java Project — финальный проект 6 спринта.

Юнит-тесты для классов семейства кошачьих: `Feline`, `Cat`, `Lion` и дополнительного класса `Alex`.

## Стек
- Java 11
- JUnit 4.13.2 (в том числе раннер `Parameterized`)
- Mockito 5.11.0 (`@Mock`, `@Spy`, `when`, `verify`)
- Jacoco 0.8.12 (отчёт о покрытии)

## Запуск
```bash
mvn clean test
```
Отчёт Jacoco: `target/site/jacoco/index.html`.

## Что изменено в коде
- `Lion` больше не создаёт `Feline` внутри себя: объект передаётся через конструктор `Lion(String sex, Feline feline)` (инъекция зависимости).
- Добавлен класс `Alex extends Lion`: `getFriends()`, `getPlaceOfLiving()`, переопределённый `getKittens()` возвращает 0.

## Карта покрытия
| Класс | Метод / ветка | Тест |
|---|---|---|
| Feline | `eatMeat()` | `FelineTest.eatMeatReturnsPredatorFood`, `eatMeatCallsGetFoodWithPredator` |
| Feline | `getFamily()` | `FelineTest.getFamilyReturnsFeline` |
| Feline | `getKittens()` | `FelineTest.getKittensWithoutArgsReturnsOne`, `getKittensWithoutArgsCallsGetKittensWithOne` |
| Feline | `getKittens(int)` | `FelineParameterizedTest` (0, 1, 5) |
| Cat | `getSound()` | `CatTest.getSoundReturnsMeow` |
| Cat | `getFood()` | `CatTest.getFoodReturnsPredatorFood`, `getFoodCallsEatMeat` |
| Lion | конструктор: «Самец» / «Самка» | `LionParameterizedTest` |
| Lion | конструктор: неверный пол → исключение | `LionTest.constructorWithInvalidSexThrowsException` |
| Lion | `getKittens()`, `getFood()` | `LionTest` |
| Lion | `doesHaveMane()` | `LionParameterizedTest` |
| Alex | все методы | `AlexTest` |

## Результат прогона (09.10.2026)
`mvn clean test` (Maven 3.9.16, JDK 16, `release 11`) → **BUILD SUCCESS**, 20 тестов, 0 падений.

| Класс | Инструкции | Ветки | Строки | Методы |
|---|---|---|---|---|
| Feline | 100% | — | 100% | 100% |
| Cat | 100% | — | 100% | 100% |
| Lion | 100% | 100% | 100% | 100% |
| Alex | 100% | — | 100% | 100% |
