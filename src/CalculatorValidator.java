import java.util.Scanner;

public class CalculatorValidator {

    static double tryCatchDoubleValidator(Scanner scanner, String message){
        while(true){
            System.out.print(message);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Wrong input! Please enter a valid integer.");
            }
        }
    }

}
