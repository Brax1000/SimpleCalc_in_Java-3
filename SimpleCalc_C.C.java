import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("           SIMPLE JAVA CALCULATOR         ");
        System.out.println("=========================================");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add       (+)");
            System.out.println("2. Subtract  (-)");
            System.out.println("3. Multiply  (*)");
            System.out.println("4. Divide    (/)");
            System.out.println("5. Modulus   (%)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            String choiceInput = scanner.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                continue;
            }

            if (choice == 6) {
                running = false;
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice! Please select a valid option.");
                continue;
            }

            double num1, num2;

            try {
                System.out.print("Enter first number: ");
                num1 = Double.parseDouble(scanner.nextLine().trim());

                System.out.print("Enter second number: ");
                num2 = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number entered. Please try again.");
                continue;
            }

            double result = 0;
            String operatorSymbol = "";
            boolean validOperation = true;

            switch (choice) {
                case 1:
                    result = num1 + num2;
                    operatorSymbol = "+";
                    break;
                case 2:
                    result = num1 - num2;
                    operatorSymbol = "-";
                    break;
                case 3:
                    result = num1 * num2;
                    operatorSymbol = "*";
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    } else {
                        result = num1 / num2;
                        operatorSymbol = "/";
                    }
                    break;
                case 5:
                    if (num2 == 0) {
                        System.out.println("Error: Modulus by zero is not allowed.");
                        validOperation = false;
                    } else {
                        result = num1 % num2;
                        operatorSymbol = "%";
                    }
                    break;
            }

            if (validOperation) {
                System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, operatorSymbol, num2, result);
            }

            System.out.print("\nDo you want to perform another calculation? (y/n): ");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("y") && !again.equals("yes")) {
                running = false;
                System.out.println("Exiting calculator. Goodbye!");
            }
        }

        scanner.close();
    }
}
