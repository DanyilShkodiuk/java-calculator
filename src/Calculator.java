import java.util.Scanner;
public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = CalculatorValidator.tryCatchIntValidator(scanner, "Enter first number: ");
        int secondNumber =  CalculatorValidator.tryCatchIntValidator(scanner, "Enter second number: ");

        System.out.println("\nFirst number: " + firstNumber + "\n" + "Second number: " + secondNumber + "\n");


        CalculatorMenu.printMenu();
        System.out.print("Operation: ");
        String operation = scanner.next();
        System.out.println();

        while (!operation.equalsIgnoreCase(CalculatorMenu.operationNames[6])){

            int result = 0;
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
                    if (secondNumber == 0) {
                        System.out.println("Cannot divide by 0. Enter another number: ");
                        secondNumber = scanner.nextInt();
                        validOperation = false;
                    } else {
                        result = CalculatorLogic.division(firstNumber, secondNumber);
                    }
                }
                case "%" -> {
                    if (secondNumber == 0) {
                        System.out.println("Cannot divide by 0. Enter another number: ");
                        secondNumber = scanner.nextInt();
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
                                    firstNumber = scanner.nextInt();
                                }
                                case "second" -> {
                                    System.out.println("Enter second number: ");
                                    secondNumber = scanner.nextInt();
                                }
                                case "exit" -> System.out.println("Numbers now: " + firstNumber + ", " + secondNumber);
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
                    System.out.println("Result: " + result);
                }

                CalculatorMenu.printMenu();
                operation = scanner.next();
        }
        // Program exit message moved outside loop — prints once
        System.out.println("Exit calculator");
        scanner.close();
    }
}