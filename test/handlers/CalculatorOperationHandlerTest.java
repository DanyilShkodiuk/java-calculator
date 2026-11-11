package handlers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorOperationHandlerTest {

    private static final double DELTA = 1e-9;

    @Test
    void addsTwoNumbers() {
        assertEquals(17.0, CalculatorOperationHandler.addition(12, 5), DELTA);
    }

    @Test
    void subtractsTwoNumbers() {
        assertEquals(-3.5, CalculatorOperationHandler.subtraction(1.5, 5), DELTA);
    }

    @Test
    void multipliesTwoNumbers() {
        assertEquals(60.0, CalculatorOperationHandler.multiplication(12, 5), DELTA);
    }

    @Test
    void dividesTwoNumbers() {
        assertEquals(2.4, CalculatorOperationHandler.division(12, 5), DELTA);
    }

    @Test
    void returnsRemainderForModulo() {
        assertEquals(2.0, CalculatorOperationHandler.modulo(12, 5), DELTA);
    }
}
