import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCheck {

    private static void checkUserLogin (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        boolean matchLogin = login.matches("\\w+");
        boolean matchPassword = password.matches("\\w+");
        if (!matchLogin) {
            System.out.println();
            throw new WrongLoginException("Login содержит в себе только латинские буквы, цифры и знак подчеркивания");
        } else if (login.length()> 20 || login.isEmpty()) {
            throw new WrongLoginException("Login есть ограничение по длине – он должен быть равен или меньше 20 символов");
        } else if (!matchPassword) {
            throw new WrongPasswordException("Password содержит в себе только латинские буквы, цифры и знак подчеркивания");
        } else if (password.isEmpty() || password.length() > 20) {
            throw new WrongPasswordException("password есть ограничение по длине – он должен быть равен или меньше 20 символов");
        } else if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Параметры password и confirmPassword должны быть равны");
        }
    }

    public static boolean checker (String login, String password, String confirmPassword) {
        try {
            checkUserLogin(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            return false;
        }
    }
}
