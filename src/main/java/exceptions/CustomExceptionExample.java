package exceptions;

public class CustomExceptionExample {
    public static void main(String args[]) {
        try {
            throw new CustomException(2);
            // throw is used to create a new exception and throw it.
        } catch (CustomException e) {
            System.out.println(e);
        }

    }
}

class CustomException extends Exception {
    int a;

    CustomException(int b) {
        a = b;
    }

    public String toString() {
        return ("Exception Number =  " + a);
    }
}

