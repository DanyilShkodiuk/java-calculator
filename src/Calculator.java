import java.awt.*;
import java.util.Scanner;

public class Calculator {

    // NEW: Created a helper method to avoid repeating the menu text.
    // Before: You printed the same menu in every case.
    // Now: You just call printMenu() to show it — cleaner and easier to update
    static void printMenu(){
        System.out.println("what operation do you want to do? Provide Symbol( \n1.+ \n2.- \n3.* \n4./ \n5.% \n6.Change \nExit ");
    }

    static int addition(int first, int second) {
        return first + second;
    }
    static int subtraction(int first, int second) {
        return first - second;
    }
    static int multiplication(int first, int second) {
        return first * second;
    }
    static int division(int first, int second) {
        return first / second;
    }
    static int modulo(int first, int second) {
        return first % second;
    }
    static int getValidInt(Scanner scanner, String message){
        System.out.print(message);
        while(!scanner.hasNextInt()){
            System.out.print("Wrong input! Please enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = getValidInt(scanner, "Enter first number: ");
        int secondNumber =  getValidInt(scanner, "Enter second number: ");

        System.out.println("You entered: " + firstNumber + " " + secondNumber);

        // CHANGED: printMenu() replaces hardcoded text.
        printMenu();
        String operation = scanner.next();

        //CHANGED: Added equalsIgnoreCase("Exit") — more user-friendly (accepts 'exit' or 'EXIT')
        while (!operation.equalsIgnoreCase("Exit")){
            // NEW VARIABLES: introduced result + validOperation
            // Purpose: Prevent printing result after invalid input or "Change" menu.
            int result = 0;
            boolean validOperation = true;

            // CHANGED: Switched to Java 14+ "arrow switch" syntax for cleaner code (→)
            // It’s more modern, readable, and prevents fall-through errors.
            switch (operation) {
                case "+" -> result = addition(firstNumber, secondNumber);

                case "-" -> result = subtraction(firstNumber, secondNumber);

                case "*" -> result = multiplication(firstNumber, secondNumber);

                // IMPROVED: Division now checks for zero BEFORE performing operation
                case "/" -> {
                    if (secondNumber == 0) {
                        System.out.println("Cannot divide by 0. Enter another number: ");
                        secondNumber = scanner.nextInt();
                        validOperation = false;
                    } else {
                        result = division(firstNumber, secondNumber);
                    }
                }
                // IMPROVED: Same protection added for modulo
                case "%" -> {
                    if (secondNumber == 0) {
                        System.out.println("Cannot divide by 0. Enter another number: ");
                        secondNumber = scanner.nextInt();
                        validOperation = false;
                    } else {
                        result = modulo(firstNumber, secondNumber);
                    }
                }
                // "Change" block rewritten with inner while loop for clarity.
                // Old version returned to main switch immediately — now user can change multiple numbers without leaving.
                    case "Change" -> {
                        String choice = "";
                        while (!choice.equalsIgnoreCase("Exit")) {
                            System.out.println("Which number would you like to change? ");
                            System.out.println("1. first\n2. second\n3. exit");
                            choice = scanner.next();
                            // Used nested arrow switch — simpler syntax, fewer braces.
                            switch (choice) {
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
                    // Default case cleaned up: prints once and continues.
                    default -> {
                        System.out.println("Invalid operation! Try again or type Exit.");
                        validOperation = false;
                    }
                }
                // NEW CHECK: result printed only if operation was valid
                if (validOperation && !operation.equalsIgnoreCase("Change")) {
                    System.out.println("Result: " + result);
                }
                // printMenu() reused instead of repeated text
                printMenu();
                operation = scanner.next();
        }
        // Program exit message moved outside loop — prints once
        System.out.println("Exit calculator");
        scanner.close();
    }
}