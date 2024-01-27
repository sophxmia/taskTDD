package patterns.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static final double EPS = 0.001;
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testCalculateFunction() {
        double x1 = 0.0;
        double x2 = 1.4;
        double x3 = 2.0;

        double a = 2.7;
        double b = -0.3;
        double c = 4.0;

        double result1 = main.calculateFunction(x1, a, b, c);
        double result2 = main.calculateFunction(x2, a, b, c);
        double result3 = main.calculateFunction(x3, a, b, c);

        assertEquals(4.0, result1, EPS);
        assertEquals(3.649, result2,EPS);
        assertEquals(4.336, result3, EPS);
    }

    @Test
    void testCalculateSteps(){
        assertEquals(6, main.calculateSteps(0.0, 1.0, 0.2));
        assertEquals(11, main.calculateSteps(0.0, 2.0, 0.2));
        assertEquals(1001, main.calculateSteps(0.0, 2.0, 0.002));
    }

    @Test
    void testGenerateFunctionValues(){
        double start = 0.0;
        double end = 2.0;
        double step = 0.002;

        double a = 2.7;
        double b = -0.3;
        double c = 4.0;

        int steps = main.calculateSteps(start, end, step);
        double[] expectedValues = new double[steps];

        for (int i = 0; i < steps; i++) {
            double x = start + i * step;
            expectedValues[i] = main.calculateFunction(x, a, b, c);
        }

        double[] resultValues = main.generateFunctionValues(start, end, step, a, b,c);
        assertArrayEquals(expectedValues, resultValues, EPS);
    }

    @Test
    void testCalculateArgumentValues(){
        double start = 0.0;
        double end = 2.0;
        double step = 0.002;

        int steps = main.calculateSteps(start, end, step);
        double[] expectedValues = new double[steps];

        for (int i = 0; i < steps; i++) {
            expectedValues[i] = start + i * step;
        }

        double[] resultValues = main.calculateArgumentValues(start, end, step);

        assertArrayEquals(expectedValues, resultValues, EPS);
    }
}