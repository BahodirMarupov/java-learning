package exceptions.uncheckedexception;

import java.io.File;

public class IllegalArgumentExceptionExample {
    public static String createRelativePath(String par, String f_name) {

        if (par == null)
            throw new IllegalArgumentException("You cannot provide null parent path!");

        if (f_name == null)
            throw new IllegalArgumentException("Please enter the complete filename!");

        return par + File.separator + f_name;
    }

    public static void main(String[] args) {
        // This command will be successfully executed.
        System.out.println(createRelativePath("dir1", "file1"));

        // This command will throw an IllegalArgumentException.
        System.out.println(createRelativePath(null, "file1"));
    }
}
