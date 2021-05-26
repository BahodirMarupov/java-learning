package exceptions.uncheckedexception;

import java.util.ArrayList;
import java.util.ListIterator;

public class IllegalStateExceptionExample {
    public static void main(String args[]) {
        //Instantiating an ArrayList object
        ArrayList<String> list = new ArrayList<String>();
        //populating the ArrayList
        list.add("apples");
        list.add("mangoes");
        //Getting the Iterator object of the ArrayList
        ListIterator<String> it = list.listIterator();
        //Removing the element without moving to first position
        it.remove();
    }
}
