public class secondCalC {
    public static float add(float num1, float num2) {
        return num1 + num2;
    }

    public static float subtract(float num1, float num2) {
        return num1 - num2;
    }

    public static float multiply(float num1, float num2) {
        return num1 * num2;
    }

    public static float divide(float num1, float num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
    }
}
