import java.util.Scanner;

    public class Calculator {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            double firstNumber = InputHandler.getNumberFromUser(scanner, "Enter first number: ");
            double secondNumber = InputHandler.getNumberFromUser(scanner, "Enter second number: ");

            System.out.printf("\nFirst number: %.3f%nSecond number: %.3f%n", firstNumber, secondNumber);

            CalculatorHandler handler = new CalculatorHandler(firstNumber, secondNumber, scanner);

            CalculatorEnumMenu operation = InputHandler.getOperationFromUser(scanner);

            while (operation != CalculatorEnumMenu.EXIT) {
                handler.handleOperation(operation);
                operation = InputHandler.getOperationFromUser(scanner);
            }

            System.out.println("Exit calculator");
            scanner.close();
        }
    }
