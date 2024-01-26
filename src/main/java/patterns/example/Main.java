package patterns.example;

/**
 * @author Sofia Maliarenko
 *
 * Task
 */

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        double x = 1.4;
        double a = 2.7;
        double b = -0.3;
        double c = 4.0;

        double result = calculateFunction(x, a, b, c);

        System.out.println("Result: " + result);
    }

    /**
     * Counts the function's y-result
     * @param x x-value
     * @param a a-value
     * @param b b-value
     * @param c c-value
     * @return the y-value
     */
    public double calculateFunction(double x, double a, double b, double c) {
        if (x < 1.4) {
            return a * Math.pow(x, 2) + b * x + c;
        } else if (x == 1.4) {
            return a / x + Math.sqrt(Math.pow(x, 2) + 1);
        } else {
            return (a + b * x) + Math.sqrt(Math.pow(x, 2) + 1);
        }
    }
}