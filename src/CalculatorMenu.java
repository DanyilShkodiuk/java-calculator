public class CalculatorMenu {

    public static final String[] operationIcons = {"+","-","*","/","%","change","exit"};

    public static final String[] operationNames = {
        "Addition",
        "Subtraction",
        "Multiplication",
        "Division",
        "Modulo",
        "Change Numbers",
        "Exit"
    };

    public static final String[] changeMenuOperations = {
        "First",
        "Second",
        "Exit",
    };

    static void printMenu() {
        System.out.println("\n" + "Select an operation / Number of operation: ");
        for(int i = 0; i < operationIcons.length; i++) {
            System.out.println((i + 1)+ "." + operationIcons[i]);
        }
        System.out.print("\nOperation: ");
    }
    static void printChangeMenu() {
        System.out.println("\n" + "Select the number which you want to change (Type option's name or number):");
        for(int i = 0; i < changeMenuOperations.length; i++) {
            System.out.println((i + 1) + "." + changeMenuOperations[i]);
        }
        System.out.print("\nOperation: ");
    }
}
