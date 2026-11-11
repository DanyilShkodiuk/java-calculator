package handlers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputHandlerTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void captureOutput() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreOutput() {
        System.setOut(originalOut);
    }

    @Test
    void readsNumberWithDot() {
        assertEquals(3.5, InputHandler.getNumberFromUser("> ", new Scanner("3.5")), 1e-9);
    }

    @Test
    void acceptsCommaAsDecimalSeparator() {
        assertEquals(3.5, InputHandler.getNumberFromUser("> ", new Scanner("3,5")), 1e-9);
    }

    @Test
    void asksAgainUntilInputIsANumber() {
        double number = InputHandler.getNumberFromUser("> ", new Scanner("abc 42"));

        assertEquals(42.0, number, 1e-9);
        assertTrue(output.toString().contains("Wrong input!"));
    }
}
