import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для метода toString() класса Entity.
 * Проверяется корректность формирования строкового представления объекта
 * с учетом аннотации @ToString.
 */
public class EntityTest {

    /**
     * Проверяет, что метод toString() включает только те поля,
     * которые не помечены аннотацией @ToString(NO).
     */
    @Test
    public void testToStringWithVisibleField() {
        A a = new A(); // Создаем объект класса A
        String expectedOutput = "A{s=hello}"; // Ожидаемый вывод метода toString()
        System.out.println(a);
        assertEquals(expectedOutput, a.toString()); // Проверяем соответствие ожидаемого и фактического вывода
    }

    /**
     * Проверяет, что метод toString() включает только те поля,
     * которые не помечены аннотацией @ToString(NO), даже при изменении значений поля
     */
    @Test
    public void testToStringWithChangeFields() {
        A a = new A();
        // Изменяем значения и проверяем результат
        a.x = 55;
        a.s = "HeLl0_W0lD";
        String expectedOutput = "A{s=HeLl0_W0lD}";
        System.out.println(a);
        assertEquals(expectedOutput, a.toString()); // Проверяем соответствие ожидаемого и фактического вывода
    }

    /**
     * Проверяет, что метод toString() включает только те поля,
     * которые не помечены аннотацией @ToString(NO), если
     * поля с аннотацией @ToString(YES) равны null
     */
    @Test
    public void testToStringWithNoVisibleFields() {
        A a = new A();
        a.s = null; // Эмулируем отсутствие видимых полей

        // Ожидаемый результат: пустая строка
        String expectedOutput = "A{}";
        System.out.println(a);
        // Проверяем соответствие результата метода toString() ожидаемому значению
        assertEquals(expectedOutput, a.toString());
    }
}
