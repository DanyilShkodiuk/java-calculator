# Java Console Calculator

An interactive command-line calculator written in plain Java (no libraries). It keeps two numbers in memory, lets you run several operations on them in a row, and change either number without restarting.

## Features

- Addition, subtraction, multiplication, division and modulo
- Choose an operation by its number (`1`), symbol (`+`) or name (`add…`)
- Change the first or second number at any time through a sub-menu
- Input validation: invalid numbers are asked again, `,` and `.` both work as the decimal separator
- Division and modulo by zero are caught and you are asked for a new divisor

## Example

```text
Enter first number: 12
Enter second number: 5

First number: 12.000
Second number: 5.000

Select an operation / Number of operation:
1. + (Addition)
2. - (Subtraction)
3. * (Multiplication)
4. / (Division)
5. % (Modulo)
6. change (Change Numbers)
7. exit (Exit)

Operation: +
Result: 17.000
```

## Run

Requires JDK 14 or newer (the code uses switch expressions); any current LTS such as JDK 17 or 21 works.

```bash
javac -d out $(find src -name "*.java")
java -cp out Calculator
```

Or open the folder in IntelliJ IDEA and run `Calculator`.

## Project structure

```text
src/
├── Calculator.java                      # entry point and main loop
├── handlers/
│   ├── CalculatorMenuHandler.java       # runs the chosen operation, change-numbers menu
│   ├── CalculatorOperationHandler.java  # the arithmetic itself
│   └── InputHandler.java                # reading and validating user input
└── menu/
    ├── CalculatorEnumMenu.java          # main menu options
    └── CalculatorEnumChangeMenu.java    # change-numbers menu options
```

Menus are modelled as enums, so adding an operation means adding one enum value and one `case`.
