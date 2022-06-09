package exceptions;

public class WrongLoginException extends Exception {
    public WrongLoginException(String msg) {
        System.out.println(msg);
    }
}
