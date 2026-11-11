package menu;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CalculatorEnumMenuTest {

    @ParameterizedTest
    @CsvSource({
            "1, ADD",
            "+, ADD",
            "add, ADD",
            "'  Addition ', ADD",
            "4, DIV",
            "/, DIV",
            "%, MOD",
            "mod, MOD",
            "change, CHANGE",
            "7, EXIT",
            "EXIT, EXIT"
    })
    void parsesNumberSymbolOrName(String input, CalculatorEnumMenu expected) {
        assertEquals(expected, CalculatorEnumMenu.fromInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "8", "pow", "?"})
    void returnsNullForUnknownInput(String input) {
        assertNull(CalculatorEnumMenu.fromInput(input));
    }

    @ParameterizedTest
    @CsvSource({"1, FIRST", "second, SECOND", "3, EXIT", "exit, EXIT"})
    void parsesChangeMenu(String input, CalculatorEnumChangeMenu expected) {
        assertEquals(expected, CalculatorEnumChangeMenu.fromInput(input));
    }
}
