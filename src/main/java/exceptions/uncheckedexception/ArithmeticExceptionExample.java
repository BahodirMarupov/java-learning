package exceptions.uncheckedexception;

public class ArithmeticExceptionExample {
    public static void main(String args[]) {
        try {
            int p = 30, q = 0;
            int r = p / q;  // It cannot be divided by zero
            System.out.println("Result = " + r);
        } catch (ArithmeticException e) {
            System.out.println("Number cannot be divided by 0");
        }
    }
}
