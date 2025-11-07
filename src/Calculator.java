import java.util.Scanner;
public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double firstNumber = CalculatorValidator.tryCatchDoubleValidator(scanner, "Enter first number: ");
        double secondNumber =  CalculatorValidator.tryCatchDoubleValidator(scanner, "Enter second number: ");

        System.out.printf("\nFirst number: %.3f%nSecond number: %.3f%n", firstNumber, secondNumber);


        CalculatorMenu.printMenu();
        String userInput = scanner.next();
        CalculatorEnumMenu operation = CalculatorEnumMenu.fromInput(userInput);

        while (operation != CalculatorEnumMenu.EXIT){

            double result = 0;
            boolean validOperation = true;

            if (operation == null){
                System.out.println("Invalid operation! Try again or type Exit.");
                validOperation = false;
            } else {
                switch (operation) {
                    case ADD -> result = CalculatorLogic.addition(firstNumber, secondNumber);
                    case SUB -> result = CalculatorLogic.subtraction(firstNumber, secondNumber);
                    case MUL -> result = CalculatorLogic.multiplication(firstNumber, secondNumber);
                    case DIV -> {
                        if (secondNumber == 0.0) {
                            System.out.println("Cannot divide by 0. Enter another number: ");
                            secondNumber = CalculatorValidator.tryCatchDoubleValidator(scanner, "");
                            validOperation = false;
                        } else {
                            result = CalculatorLogic.division(firstNumber, secondNumber);
                        }
                    }
                    case MOD -> {
                        if (secondNumber == 0.0) {
                            System.out.println("Cannot divide by 0. Enter another number: ");
                            secondNumber = CalculatorValidator.tryCatchDoubleValidator(scanner, "");
                            validOperation = false;
                        } else {
                            result = CalculatorLogic.modulo(firstNumber, secondNumber);
                        }
                    }
                    case CHANGE -> {
                        CalculatorEnumChangeMenu changeOption = null;

                        while (changeOption != CalculatorEnumChangeMenu.EXIT) {

                            CalculatorEnumChangeMenu.printChangeMenu();
                            String changeInput = scanner.next();
                            changeOption = CalculatorEnumChangeMenu.fromInput(changeInput);

                            if (changeOption == null) {
                                System.out.println("Invalid option! Try again or type Exit.");
                                continue;
                            }

                            switch (changeOption) {
                                case FIRST -> {
                                    System.out.print("Enter first number: ");
                                    String input = scanner.next().replace(",", ".");
                                    firstNumber = Double.parseDouble(input);
                                }
                                case SECOND -> {
                                    System.out.print("Enter second number: ");
                                    String input = scanner.next().replace(",", ".");
                                    secondNumber = Double.parseDouble(input);
                                }
                                default -> System.out.println("Invalid option! Choose valid option.");
                            }
                        }

                        validOperation = false;
                    }

                }
            }

                if (validOperation) {
                    System.out.printf("Result: %.3f%n" , result);
                }

                CalculatorMenu.printMenu();
                userInput = scanner.next();
                operation = CalculatorEnumMenu.fromInput(userInput);
        }

        System.out.println("Exit calculator");
        scanner.close();
    }
}