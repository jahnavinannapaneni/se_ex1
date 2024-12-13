import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherModeling {

    // Method to calculate temperature using a cubic equation
    public static double calculateTemperature(double a, double b, double c, double d, double x) {
        return a * (x * x * x) + b * (x * x) + c * x + d;
    }

    public static void main(String[] args) {
        // Stage 1: Hard-coded variables
        double a = 0.1;  // Coefficient for the cubic term
        double b = -0.5; // Coefficient for the quadratic term
        double c = 2.0;  // Coefficient for the linear term
        double d = 10.0; // Constant term
        double x = 5.0;  // Day of the year

        // Calculate and print hard-coded temperature
        double hardCodedTemperature = calculateTemperature(a, b, c, d, x);
        System.out.printf("Hard-coded temperature for day %.1f: %.2f%n", x, hardCodedTemperature);

        // Stage 2: Keyboard input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficient a: ");
        a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        c = scanner.nextDouble();
        System.out.print("Enter coefficient d: ");
        d = scanner.nextDouble();
        System.out.print("Enter day of the year (x): ");
        x = scanner.nextDouble();

        // Calculate and print temperature from keyboard input
        double keyboardTemperature = calculateTemperature(a, b, c, d, x);
        System.out.printf("Temperature for day %.1f: %.2f%n", x, keyboardTemperature);

        // Stage 3: Reading from a file
        try {
            File file = new File("input.txt");
            Scanner fileScanner = new Scanner(file);

            // Reading from a file
            while (fileScanner.hasNextLine()) {
                a = fileScanner.nextDouble();
                b = fileScanner.nextDouble();
                c = fileScanner.nextDouble();
                d = fileScanner.nextDouble();
                x = fileScanner.nextDouble();

                double fileTemperature = calculateTemperature(a, b, c, d, x);
                System.out.printf("Temperature for day %.1f: %.2f%n", x, fileTemperature);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }

        scanner.close();
    }
}
