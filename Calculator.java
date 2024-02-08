import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Calculator");

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Select operation (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                    return; // Exit the program if division by zero is attempted
                }
                break;
            default:
                System.out.println("Error! Invalid operator.");
                return; // Exit the program if an invalid operator is entered
        }

        System.out.println("Result: " + result);

        scanner.close();
    }
}

