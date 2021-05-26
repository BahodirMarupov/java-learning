package exceptions;

public class CheckedAndUncheckedExceptionExamples {

    public void execute() {
        throw new RuntimeException("Runtime");
    }

    public void process() throws MyException {
        throw new MyException("Checked");
    }

    public static void main(String[] args) {
        CheckedAndUncheckedExceptionExamples exceptionExamples=new CheckedAndUncheckedExceptionExamples();
        exceptionExamples.execute();
        try {
            exceptionExamples.process();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}

class MyException extends Exception {
    public MyException(final String message) {
        super(message);
    }
}