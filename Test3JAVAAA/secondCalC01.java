import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class secondCalC01 {

    private Calculator calculator;

    @Before
    public void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        float num1 = 5.0f;
        float num2 = 2.0f;
        float expected = 7.0f;
        float actual = calculator.add(num1, num2);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testSubtract() {
        float num1 = 5.0f;
        float num2 = 2.0f;
        float expected = 3.0f;
        float actual = calculator.subtract(num1, num2);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testMultiply() {
        float num1 = 5.0f;
        float num2 = 2.0f;
        float expected = 10.0f;
        float actual = calculator.multiply(num1, num2);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testDivide() {
        float num1 = 10.0f;
        float num2 = 2.0f;
        float expected = 5.0f;
        float actual = calculator.divide(num1, num2);
        assertEquals(expected, actual, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        float num1 = 10.0f;
        float num2 = 0.0f;
        calculator.divide(num1, num2);
    }
}
