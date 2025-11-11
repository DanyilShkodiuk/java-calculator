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

    public static double getNumberFromUser(Scanner scanner, String message) {
        double number = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(message);
            try {
                number = Double.parseDouble(scanner.next().replace(",", "."));
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input! Please enter a valid number.");
            }
        }
        return number;
    }


}
