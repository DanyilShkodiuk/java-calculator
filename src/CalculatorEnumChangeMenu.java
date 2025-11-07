public enum CalculatorEnumChangeMenu {
    FIRST("first", "Change First Number"),
    SECOND("second", "Change Second Number"),
    EXIT("exit", "Exit Change Menu");

    private final String command;
    private final String displayName;

    CalculatorEnumChangeMenu(String command, String displayName) {
        this.command = command;
        this.displayName = displayName;
    }

    public String getCommand() {
        return command;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CalculatorEnumChangeMenu fromInput(String input) {
        input = input.trim().toLowerCase();

        try {
            int num =  Integer.parseInt(input);
            if (num >= 1 && num <= values().length) {
                return values()[num -1 ];
            }
        }catch (NumberFormatException ignored) {}

        for (CalculatorEnumChangeMenu option : CalculatorEnumChangeMenu.values()) {
            if (option.getCommand().equals(input) ||  option.getDisplayName().toLowerCase().startsWith(input)) {
                return option;
            }
        }
        return null;
    }

    public static void printChangeMenu() {
        System.out.println("\nSelect the number you want to change:");
        int index = 1;
        for (CalculatorEnumChangeMenu option : CalculatorEnumChangeMenu.values()) {
            System.out.printf("%d. %s%n", index++, option.getDisplayName());
        }
        System.out.print("\nOption: ");
    }
}
