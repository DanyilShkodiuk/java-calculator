import java.util.Scanner;

public class CalculatorValidator {
    static double getValidInt(Scanner scanner, String message){
        System.out.print(message);
        while(!scanner.hasNextInt()){
            System.out.print("Wrong input! Please enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

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
