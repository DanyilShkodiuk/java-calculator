import java.util.Scanner;
public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double firstNumber = CalculatorValidator.tryCatchDoubleValidator(scanner, "Enter first number: ");
        double secondNumber =  CalculatorValidator.tryCatchDoubleValidator(scanner, "Enter second number: ");

        System.out.printf("\nFirst number: %.3f%nSecond number: %.3f%n", firstNumber, secondNumber);


        CalculatorMenu.printMenu();
        String operation = scanner.next();

        while (!operation.equalsIgnoreCase(CalculatorMenu.operationNames[6])){

            double result = 0;
            boolean validOperation = true;

            int indexOfOperation;
            try {
                int GeneralChoice = Integer.parseInt(operation);
                if(GeneralChoice >= 1 && GeneralChoice <= CalculatorMenu.operationIcons.length){
                    indexOfOperation = GeneralChoice - 1;
                    operation = CalculatorMenu.operationIcons[indexOfOperation];
                }
            } catch (NumberFormatException ignored) {}

            switch (operation.toLowerCase()) {
                case "+" -> result = CalculatorLogic.addition(firstNumber, secondNumber);
                case "-" -> result = CalculatorLogic.subtraction(firstNumber, secondNumber);
                case "*" -> result = CalculatorLogic.multiplication(firstNumber, secondNumber);
                case "/" -> {
                    if (secondNumber == 0.0) {
                        System.out.println("Cannot divide by 0. Enter another number: ");
                        String input = scanner.next().replace(",", ".");
                        secondNumber = Double.parseDouble(input);
                        validOperation = false;
                    } else {
                        result = CalculatorLogic.division(firstNumber, secondNumber);
                    }
                }
                case "%" -> {
                    if (secondNumber == 0.0) {
                        System.out.println("Cannot divide by 0. Enter another number: ");
                        String input = scanner.next().replace(",", ".");
                        secondNumber = Double.parseDouble(input);
                        validOperation = false;
                    } else {
                        result = CalculatorLogic.modulo(firstNumber, secondNumber);
                    }
                }
                case "change" -> {
                        String choice = "";
                        while (!choice.equalsIgnoreCase("Exit")) {
                            System.out.println("Which number would you like to change? ");
                            CalculatorMenu.printChangeMenu();
                            choice = scanner.next();

                            try {
                                int ChangeChoice = Integer.parseInt(choice);
                                if(ChangeChoice >= 1 && ChangeChoice <= CalculatorMenu.changeMenuOperations.length){
                                    choice = CalculatorMenu.changeMenuOperations[ChangeChoice - 1];
                                }
                            } catch (NumberFormatException ignored) {}

                            // Used nested arrow switch — simpler syntax, fewer braces.
                            switch (choice.toLowerCase()) {
                                case "first" -> {
                                    System.out.println("Enter first number: ");
                                    String input = scanner.next().replace(",", ".");
                                    firstNumber = Double.parseDouble(input);
                                }
                                case "second" -> {
                                    System.out.println("Enter second number: ");
                                    String input = scanner.next().replace(",", ".");
                                    secondNumber = Double.parseDouble(input);
                                }
                                case "exit" -> System.out.printf("Numbers now: %.3f, %.3f%n" , firstNumber , secondNumber);
                                default -> System.out.println("Invalid option. Try again.");
                            }
                        }
                        validOperation = false; // Don’t print result after “Change”
                    }
                case "exit" -> {
                    System.out.println("Exiting Calculator");
                    return;
                }
                default -> {
                        System.out.println("Invalid operation! Try again or type Exit.");
                        validOperation = false;
                    }
                }
                if (validOperation) {
                    System.out.printf("Result: %.3f%n" , result);
                }

                CalculatorMenu.printMenu();
                operation = scanner.next();
        }
        // Program exit message moved outside loop — prints once
        System.out.println("Exit calculator");
        scanner.close();
    }
}