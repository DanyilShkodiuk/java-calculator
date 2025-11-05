import java.util.Scanner;

public class CalculatorValidator {
    static int getValidInt(Scanner scanner, String message){
        System.out.print(message);
        while(!scanner.hasNextInt()){
            System.out.print("Wrong input! Please enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    static int tryCatchIntValidator(Scanner scanner, String message){
        while(true){
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Wrong input! Please enter a valid integer.");
            }
        }

    }


}
