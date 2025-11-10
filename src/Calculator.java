import java.util.Scanner;
public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double firstNumber = CalculatorValidator.tryCatchDoubleValidator(scanner, "Enter first number: ");
        double secondNumber =  CalculatorValidator.tryCatchDoubleValidator(scanner, "Enter second number: ");

        System.out.printf("\nFirst number: %.3f%nSecond number: %.3f%n", firstNumber, secondNumber);

        CalculatorEnumMenu operation = InputHandler.getOperationFromUser(scanner);

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

                            changeOption = InputHandler.getChangeOperationFromUser(scanner);

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
                            }
                            System.out.println("\nFirst Number: " + firstNumber + "\nSecondNumberL: "  + secondNumber);
                        }

                        validOperation = false;
                    }

                }
            }

                if (validOperation) {
                    System.out.printf("Result: %.3f%n" , result);
                }
            operation = InputHandler.getOperationFromUser(scanner);
        }

        System.out.println("Exit calculator");
        scanner.close();
    }
}