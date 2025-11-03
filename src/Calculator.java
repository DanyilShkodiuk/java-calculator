import java.util.Scanner;

public class Calculator {

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Type first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Type second number: ");
        int secondNumber = scanner.nextInt();

        System.out.println("what operation do you want to do? Provide Symbol( \n1.+ \n2.- \n3.* \n4./ \n5.% \n6.Change \nExit ");
        String operation = scanner.next();

        while (!operation.equals("Exit")){
            switch (operation) {
                case "+":
                    int result = addition(firstNumber, secondNumber);
                    System.out.println("Addition of numbers gives you: " + result);
                    System.out.println("what operation do you want to do? Provide Symbol( \n1.+ \n2.- \n3.* \n4./ \n5.% \n6.Change \nExit ");
                    operation = scanner.next();
                    break;

                case "-":
                    result = subtraction(firstNumber, secondNumber);
                    System.out.println("Subtraction of numbers gives you: " + result);
                    System.out.println("what operation do you want to do? Provide Symbol( \n1.+ \n2.- \n3.* \n4./ \n5.% \n6.Change \nExit ");
                    operation = scanner.next();
                    break;

                case "*":
                    result = multiplication(firstNumber, secondNumber);
                    System.out.println("Multiplication of numbers gives you: " + result);
                    System.out.println("what operation do you want to do? Provide Symbol( \n1.+ \n2.- \n3.* \n4./ \n5.% \n6.Change \nExit ");
                    operation = scanner.next();
                    break;

                case "/":
                    if (secondNumber == 0) {
                        System.out.println("Invalid operation! Number cant be divide by 0! Provide other Number");
                        System.out.println("Please enter a number other than 0:");
                        secondNumber = scanner.nextInt();
                        break;
                    }else {
                        result = division(firstNumber, secondNumber);
                        System.out.println("Division of numbers gives you: " + result);
                        System.out.println("what operation do you want to do? Provide Symbol( \n1.+ \n2.- \n3.* \n4./ \n5.% \n6.Change \nExit ");
                        operation = scanner.next();
                        break;
                    }

                case "%":
                    if (secondNumber == 0) {
                        System.out.println("Invalid operation! Number cant be divide by 0! Provide other Number");
                        System.out.print("Please enter a number other than 0:");
                        secondNumber = scanner.nextInt();
                        break;
                    }else {
                        result = modulo(firstNumber, secondNumber);
                        System.out.println("Modulo of numbers gives you: " + result);
                        System.out.println("what operation do you want to do? Provide Symbol( \n1.+ \n2.- \n3.* \n4./ \n5.% \n6.Change \nExit ");
                        operation = scanner.next();
                        break;
                    }

                case "Change":
                    String decisionWhichNumToChange = "";

                    while (!decisionWhichNumToChange.equals("exit")) {
                        System.out.println("Which number do you want to change?");
                        System.out.println("1. first\n2. second\n3. exit");
                        decisionWhichNumToChange = scanner.next();

                        if (decisionWhichNumToChange.equals("first")) {
                            System.out.print("Please enter the first number: ");
                            firstNumber = scanner.nextInt();
                            System.out.println("The first number is now: " + firstNumber);
                        } else if (decisionWhichNumToChange.equals("second")) {
                            System.out.print("Please enter the second number: ");
                            secondNumber = scanner.nextInt();
                            System.out.println("The second number is now: " + secondNumber);
                        } else if (decisionWhichNumToChange.equals("exit")) {
                            System.out.println("Numbers now: " + firstNumber + " and " + secondNumber);
                        } else {
                            System.out.println("Invalid option. Try again.");
                        }
                    }

                    // When user types "exit", go back to main calculator loop
                    System.out.println("what operation do you want to do? Provide Symbol( \n1.+ \n2.- \n3.* \n4./ \n5.% \n6.Change \nExit ");
                    operation = scanner.next();
                    break;

                default:
                    System.out.println("Invalid operation! Try again or type Exit.");
                    System.out.println("what operation do you want to do? Provide Symbol( \n1.+ \n2.- \n3.* \n4./ \n5.% \n6.Change \nExit ");
                    operation = scanner.next();
                    break;
            }
        }
            System.out.println("Exit calculator");

        scanner.close();

    }
}