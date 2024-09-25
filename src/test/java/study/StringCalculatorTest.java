package study;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void testAddition() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("2 + 3");
        assertEquals(5, result);
    }

    @Test
    void testSubtraction() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("10 - 7");
        assertEquals(3, result);
    }

    @Test
    void testMultiplication() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("3 * 4");
        assertEquals(12, result);
    }

    @Test
    void testDivision() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("20 / 5");
        assertEquals(4, result);
    }

    @Test
    void testMixedOperations() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("2 + 3 * 4 / 2");
        assertEquals(10, result); // Left to right, ((2 + 3) * 4) / 2 = 10
    }

    @Test
    void testDivisionByZero() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate("10 / 0");
        });
    }

    @Test
    void testInvalidOperator() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("10 & 5");
        });
    }

    @Test
    void testEmptyInput() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("");
        });
    }

    @Test
    void testNullInput() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(null);
        });
    }
}