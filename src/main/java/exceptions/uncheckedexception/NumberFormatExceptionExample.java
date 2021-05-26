package exceptions.uncheckedexception;

public class NumberFormatExceptionExample {
    public static void main(String args[]) {
        try {
            // "Test" is not a number
            int n = Integer.parseInt("Test");
            System.out.println(n);
        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
    }
}
