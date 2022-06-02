import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCheck {

    public static boolean checkUserLogin (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        Pattern p1 = Pattern.compile("[!@#$%^&*()А-я]");
        Matcher m1 = p1.matcher(login);
        Matcher m2 = p1.matcher(password);
        if (m1.find()) {
            System.out.println("Login содержит в себе только латинские буквы, цифры и знак подчеркивания");
            return false;
        } else if (login.length()> 20 || login.length()<=0) {
            throw new WrongLoginException();
        } else if (m2.find()) {
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

    public static boolean checker (String login, String password, String confirmPassword) {
        try {
            checkUserLogin(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Login есть ограничение по длине – он должен быть равен или меньше 20 символов");
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Параметры password и confirmPassword должны быть равны");
            return false;
        }
        return true;
    }
}
