import java.util.Scanner;

public class CalculatorHandler {

    private double firstNumber;
    private double secondNumber;
    private final Scanner scanner;

    public CalculatorHandler(double firstNumber, double secondNumber, Scanner scanner) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.scanner = scanner;
    }

    public void handleOperation(CalculatorEnumMenu operation) {
        double result = 0;
        boolean validOperation = true;

        if (operation == null) {
            System.out.println("Invalid operation! Try again or type Exit.");
            return;
        }

        switch (operation) {
            case ADD -> result = CalculatorLogic.addition(firstNumber, secondNumber);
            case SUB -> result = CalculatorLogic.subtraction(firstNumber, secondNumber);
            case MUL -> result = CalculatorLogic.multiplication(firstNumber, secondNumber);
            case DIV -> {
                if (secondNumber == 0.0) {
                    System.out.println("Cannot divide by 0. Enter another number: ");
                    secondNumber = InputHandler.getNumberFromUser(scanner, "Enter second number: ");
                    validOperation = false;
                } else {
                    result = CalculatorLogic.division(firstNumber, secondNumber);
                }
            }
            case MOD -> {
                if (secondNumber == 0.0) {
                    System.out.println("Cannot divide by 0. Enter another number: ");
                    secondNumber = InputHandler.getNumberFromUser(scanner, "Enter second number: ");
                    validOperation = false;
                } else {
                    result = CalculatorLogic.modulo(firstNumber, secondNumber);
                }
            }
            case CHANGE -> {
                handleChangeMenu();
                validOperation = false;
            }
        }

        if (validOperation) {
            System.out.printf("Result: %.3f%n", result);
        }
    }

    private void handleChangeMenu() {
        CalculatorEnumChangeMenu changeOption = null;

        while (changeOption != CalculatorEnumChangeMenu.EXIT) {
            changeOption = InputHandler.getChangeOperationFromUser(scanner);

            if (changeOption == null) {
                System.out.println("Invalid option! Try again or type Exit.");
                continue;
            }

            switch (changeOption) {
                case FIRST -> firstNumber = InputHandler.getNumberFromUser(scanner, "Enter first number: ");
                case SECOND -> secondNumber = InputHandler.getNumberFromUser(scanner, "Enter second number: ");
            }

            System.out.println("\nFirst Number: " + firstNumber + "\nSecond Number: " + secondNumber);
        }
    }
}
