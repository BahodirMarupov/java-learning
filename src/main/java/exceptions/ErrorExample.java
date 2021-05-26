package exceptions;

import java.nio.charset.StandardCharsets;

public class ErrorExample {
    private static int a = 0;

    public static void main(String[] args) {
        byte[] bytes = "01234567abcdefgABCDEFG".getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes);
    }
}
