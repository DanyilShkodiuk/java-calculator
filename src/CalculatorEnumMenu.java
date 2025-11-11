public enum CalculatorEnumMenu {
    ADD("+", "Addition"),
    SUB("-", "Subtraction"),
    MUL("*", "Multiplication"),
    DIV("/", "Division"),
    MOD("%", "Modulo"),
    CHANGE("change", "Change Numbers"),
    EXIT("exit", "Exit");

    private final String symbol;
    private final String displayName;

    CalculatorEnumMenu(String symbol, String displayName) {
        this.symbol = symbol;
        this.displayName = displayName;
    }

    public String getSymbol() {
        return symbol;
    }
    public String getDisplayName() {
        return displayName;
    }

    public static CalculatorEnumMenu fromInput(String input) {
        input = input.trim().toLowerCase();

        try {
            int num = Integer.parseInt(input);
            if (num >= 1 && num <= values().length) {
                return values()[num - 1];
            }
        } catch (NumberFormatException ignored) {}

        for (CalculatorEnumMenu operation : CalculatorEnumMenu.values()) {
            if (operation.symbol.equalsIgnoreCase(input) || operation.displayName.toLowerCase().startsWith(input)) {
                return operation;
            }
        }
        return null;
    }

    public static void printMenu() {
        System.out.println("\nSelect an operation / Number of operation:");
        int index = 1;
        for (CalculatorEnumMenu op : CalculatorEnumMenu.values()) {
            System.out.printf("%d. %s (%s)%n", index++, op.getSymbol(), op.getDisplayName());
        }
        System.out.print("\nOperation: ");
    }
}