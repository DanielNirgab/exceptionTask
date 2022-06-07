import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCheck {

    private static boolean checkUserLogin (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        boolean matchLogin = login.matches("\\w*");
        boolean matchPassword = password.matches("\\w*");
        if (!matchLogin) {
            System.out.println("Login содержит в себе только латинские буквы, цифры и знак подчеркивания");
            return false;
        } else if (login.length()> 20 || login.length()<=0) {
            throw new WrongLoginException();
        } else if (!matchPassword) {
            System.out.println("Password содержит в себе только латинские буквы, цифры и знак подчеркивания");
            return false;
        } else if (password.length() <= 0 || password.length() > 20) {
            System.out.println("password есть ограничение по длине – он должен быть равен или меньше 20 символов");
            return false;
        } else if (!password.equals(confirmPassword)){
            throw new WrongPasswordException();
        } else {
            return true;
        }
    }

    public static void checker (String login, String password, String confirmPassword) {
        try {
            checkUserLogin(login, password, confirmPassword);
            System.out.println("TRUE");
        } catch (WrongLoginException e) {
            System.out.println("Login есть ограничение по длине – он должен быть равен или меньше 20 символов");
        } catch (WrongPasswordException e) {
            System.out.println("Параметры password и confirmPassword должны быть равны");
        }
    }
}
