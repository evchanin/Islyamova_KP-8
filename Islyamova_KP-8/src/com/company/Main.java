package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите логин:");
        String login = sc.nextLine();
        System.out.println("введите пароль:");
        String password = sc.nextLine();
        try {
            checkLogInInfo(login, password, "[\\w]{1,20}");
            System.out.println("Login and password are correct!" + "User login&password confirmation");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage() + "UserException");
        }
    }

    private static boolean checkLogInInfo(String login, String password, String regex)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches(regex) | login.length() >= 20) {
            throw new WrongLoginException("Incorrect login, ");
        } else if (!password.matches(regex) | password.length() >= 20){
            throw new WrongPasswordException("Incorrect password, ");
        }
        return true;
    }
}

