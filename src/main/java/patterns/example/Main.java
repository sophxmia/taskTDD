package patterns.example;

/**
 * @author Sofia Maliarenko
 * Task №3
 */

public class Main {

    private static final double X = 1.4;
    private static final double START_X = 0.0;
    private static final double END_X = 2.0;
    private static final double STEP_X = 0.002;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        double x = X;
        double coefficientA = 2.7;
        double coefficientB = -0.3;
        double coefficientC = 4.0;

        printInputValues(x, coefficientA, coefficientB, coefficientC);

        double result = calculateFunction(x, coefficientA, coefficientB, coefficientC);
        printFunctionResult(result);

        double[] functionValues = generateFunctionValues(START_X, END_X, STEP_X, coefficientA, coefficientB, coefficientC);
        printAdditionalResults(functionValues);
    }

    /**
     * Prints the input values of x, a, b, and c.
     *
     * @param x The x-value
     * @param a The a-value
     * @param b The b-value
     * @param c The c-value
     */
    private void printInputValues(double x, double a, double b, double c) {
        System.out.println("Input values:");
        System.out.println("x: " + x);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
    }

    /**
     * Prints the result of the function calculation.
     *
     * @param result The result of the function calculation
     */
    private void printFunctionResult(double result) {
        System.out.println("\nResult of the function calculation: " + result);
    }

    /**
     * Calculates and returns an array of argument values within the specified interval and step.
     *
     * @return An array of argument values
     */
    private double[] calculateArguments() {
        int steps = calculateSteps(Main.START_X, Main.END_X, Main.STEP_X);
        double[] values = new double[steps];

        for (int i = 0; i < steps; i++) {
            values[i] = Main.START_X + i * Main.STEP_X;
        }
        return values;
    }

    /**
     * Prints additional results including max element, min element, sum, and average.
     *
     * @param functionValues The array of function values
     */
    private void printAdditionalResults(double[] functionValues) {
        int maxIndex = findMaxIndex(functionValues);
        int minIndex = findMinIndex(functionValues);
        double sum = calculateSum(functionValues);
        double average = calculateAverage(functionValues);

        System.out.println("\nAdditional results:");
        System.out.println("Max element: " + functionValues[maxIndex] + " at argument: " + calculateArguments()[maxIndex]);
        System.out.println("Min element: " + functionValues[minIndex] + " at argument: " + calculateArguments()[minIndex]);
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average: " + average);
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
     *
     * @param values an array of function values
     */
    public void displayMaxElement(double[] values) {
        int maxIndex = findMaxIndex(values);
        double maxValue = values[maxIndex];
        double maxArgument = calculateArgumentValues(0.0, 2.0, 0.002)[maxIndex];

        System.out.println("Max element: " + maxValue + " at argument: " + maxArgument + ", index: " + maxIndex);
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

        System.out.println("Min element: " + minValue + " at argument: " + minArgument + ", index: " + minIndex);
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