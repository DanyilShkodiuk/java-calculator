import java.util.Scanner;

public class InputHandler {

    public static CalculatorEnumMenu getOperationFromUser(Scanner scanner) {
        CalculatorEnumMenu.printMenu();
        String input = scanner.next();
        return CalculatorEnumMenu.fromInput(input);
    }

    public static CalculatorEnumChangeMenu getChangeOperationFromUser(Scanner scanner) {
        CalculatorEnumChangeMenu.printChangeMenu();
        String changeInput = scanner.next();
        return CalculatorEnumChangeMenu.fromInput(changeInput);
    }
}
