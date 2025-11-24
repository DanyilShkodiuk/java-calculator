import handlers.CalculatorMenuHandler;
import handlers.InputHandler;
import menu.CalculatorEnumMenu;

import java.util.Scanner;

    public class Calculator {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            double firstNumber = InputHandler.getNumberFromUser("Enter first number: ", scanner);
            double secondNumber = InputHandler.getNumberFromUser("Enter second number: ", scanner);

            System.out.printf("\nFirst number: %.3f%nSecond number: %.3f%n", firstNumber, secondNumber);

            CalculatorMenuHandler handler = new CalculatorMenuHandler(firstNumber, secondNumber, scanner);

            CalculatorEnumMenu operation = InputHandler.getOperationFromUser(scanner);

            while (operation != CalculatorEnumMenu.EXIT) {
                handler.handleOperation(operation);
                operation = InputHandler.getOperationFromUser(scanner);
            }

            System.out.println("Exit calculator");
            scanner.close();
        }
    }
