package patterns.example;

/**
 * @author Sofia Maliarenko
 * <p>
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
     *
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

    /**
     * Count the number of steps for tabulation
     *
     * @param start start value
     * @param end   end value
     * @param step  step
     * @return number of steps
     */
    public int calculateSteps(double start, double end, double step) {
        if (step <= 0) {
            throw new IllegalArgumentException("The step must be more than 0");
        }
        return (int) Math.ceil((end - start) / step) + 1;
    }

    /**
     * Create an array of function values for the specified interval and step
     *
     * @param start initial value of an argument
     * @param end   final value of an argument
     * @param step  step
     * @param a     a-value
     * @param b     b-value
     * @param c     c-value
     * @return an array of y-function values
     */
    public double[] generateFunctionValues(double start, double end, double step, double a, double b, double c) {
        int steps = calculateSteps(start, end, step);
        double[] values = new double[steps];

        for (int i = 0; i < steps; i++) {
            double x = start + i * step;
            values[i] = calculateFunction(x, a, b, c);
        }
        return values;
    }

    /**
     * Create an array of arguments for the specified interval and step
     *
     * @param start initial value of an argument
     * @param end   final value of an argument
     * @param step  step
     * @return array of arguments
     */
    public double[] calculateArgumentValues(double start, double end, double step) {
        int steps = calculateSteps(start, end, step);
        double[] values = new double[steps];

        for (int i = 0; i < steps; i++) {
            values[i] = start + i * step;
        }
        return values;
    }
}