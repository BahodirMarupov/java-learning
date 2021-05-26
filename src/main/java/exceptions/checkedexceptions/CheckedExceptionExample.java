package exceptions.checkedexceptions;

import java.io.FileInputStream;
import java.io.IOException;

public class CheckedExceptionExample {
    public static void main(String args[]) throws IOException {
        FileInputStream input1 = null;

        /* FileInputStream(File filename) is a constructor that will throw
         *     FileNotFoundException (a checked exception)
         */

        input1 = new FileInputStream("D:/file.txt");
        int m;

        // The read() of FileInputStream will also throw a checked exception
        while ((m = input1.read()) != -1) {
            System.out.print((char) m);
        }

        // The close() will close the file input stream, and it will also throw a exception
        input1.close();
    }
}
