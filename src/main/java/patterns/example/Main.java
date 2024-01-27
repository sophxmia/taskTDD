package patterns.example;

/**
 * @author Sofia Maliarenko
 * Task №3
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

    /**
     * Finds the number of the largest element in the array of function values
     *
     * @param values an array of function values
     * @return the number of the largest element
     */
    public int findMaxIndex(double[] values) {
        if (values.length == 0) throw new IllegalArgumentException("An array can't be empty");

        int maxIndex = 0;

        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    /**
     * Finds the number of the smallest element in the array of function values
     *
     * @param values an array of function values
     * @return the number of the smallest element
     */
    public int findMinIndex(double[] values) {
        if (values.length == 0) throw new IllegalArgumentException("An array can't be empty");

        int minIndex = 0;

        for (int i = 1; i < values.length; i++) {
            if (values[i] < values[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * Display the maximum element and its corresponding argument value
     * @param values an array of function values
     */
    public void displayMaxElement(double[] values) {
        int maxIndex = findMaxIndex(values);
        double maxValue = values[maxIndex];
        double maxArgument = calculateArgumentValues(0.0, 2.0, 0.002)[maxIndex];

        System.out.println("Max element: " + maxValue + " at argument: " + maxArgument);
    }

    /**
     * Display the minimum element and its corresponding argument value
     *
     * @param values an array of function values
     */

    public void displayMinElement(double[] values) {
        int minIndex = findMinIndex(values);
        double minValue = values[minIndex];
        double minArgument = calculateArgumentValues(0.0, 2.0, 0.002)[minIndex];

        System.out.println("Max element: " + minValue + " at argument: " + minArgument);
    }

    /**
     * Calculates the sum of the elements of the array of function values
     *
     * @param values an array of function values
     * @return sum of elements
     */
    public double calculateSum(double[] values) {
        double sum = 0;

        for (double value : values) sum += value;

        return sum;
    }

    /**
     * Calculates the average of the elements of the array of function values
     *
     * @param values an array of function values
     * @return average
     */
    public double calculateAverage(double[] values) {
        if (values.length == 0) throw new IllegalArgumentException("An array can't be empty");

        double sum = calculateSum(values);

        return sum / values.length;
    }
}