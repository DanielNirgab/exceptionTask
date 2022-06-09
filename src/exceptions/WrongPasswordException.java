package exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(String msg) {
        System.out.println(msg);
    }
}
