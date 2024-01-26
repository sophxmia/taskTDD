package patterns.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
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
    }
}