package calculator;

import java.util.Scanner;

public class CommandLineCalculator {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Command-Line Calculator");
			System.out.println("************************"); 
			System.out.println("\nSupported operations: (+, -, *, /)");
			System.out.println("Enter expressions (or 'exit' to quit):");
			System.out.println("**************************************");

			while (true) {
			    System.out.print("> ");
			    String input = scanner.nextLine();

			    if (input.equalsIgnoreCase("exit")) {
			        break;
			    }

			    try {
			        String[] tokens = input.split(" ");
			        if (tokens.length != 3) {
			            throw new IllegalArgumentException("Invalid expression.\nPlease use the format 'operand operator operand'.");
			        }

			        double operand1 = Double.parseDouble(tokens[0]);
			        String operator = tokens[1];
			        double operand2 = Double.parseDouble(tokens[2]);
			        double result = calculate(operand1,operator,operand2);

			        System.out.println("Result: " + result);
			        System.out.println("-----------------");
			    } catch (NumberFormatException e) {
			        System.err.println("Error: Invalid number format.");
			    } catch (IllegalArgumentException e) {
			        System.err.println("Error: " + e.getMessage());
			    }
			}
		}
        System.out.println("******************************"); 
        System.out.println("Calculator is closed.");
    }

    private static double calculate(double operand1, String operator, double operand2) {
        double result = 0.0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    System.err.println("Error: Division by zero is not allowed.");
                }
                break;
        }
        return result;
    }
}
