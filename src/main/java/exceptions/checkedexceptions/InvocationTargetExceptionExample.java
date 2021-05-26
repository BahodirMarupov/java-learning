package exceptions.checkedexceptions;

import java.lang.reflect.Method;

public class InvocationTargetExceptionExample {
    public static void main(String[] args) {
        TargetInvocation ti = new TargetInvocation();

        // Accessing all the methods of TargetInvocationClass:
        Method[] m = TargetInvocation.class.getMethods();
        try {
            // Invoking the first method of the TargetInvocatioClass:
            m[0].invoke(ti);
        } catch (Exception e) {
            // Printing the wrapper exception:
            System.out.println("Wrapper exception: " + e);

            // Printing the 'actual' exception:
            System.out.println("Underlying exception: " + e.getCause());
        }
    }
}

class TargetInvocation {
    public void Demo() {
        // Dividing by zero to intentionally throw an exception:
        System.out.println(10 / 0);
    }
}
