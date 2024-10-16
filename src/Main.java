import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        /*✅
        //✅ Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
        //✅ Login должен содержать только латинские буквы, цифры и знак подчеркивания.
        //✅ Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
        //✅ Password должен содержать только латинские буквы, цифры и знак подчеркивания. Длина password должна быть меньше 20 символов.
        Также password и confirmPassword должны быть равны. Если password не соответствует этим требованиям, необходимо выбросить
        WrongPasswordException.
        //✅ WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами
        //✅ один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
        //✅ Обработка исключений проводится внутри метода.
        //✅ Используем multi-catch block.
        //✅ Метод возвращает true, если значения верны или false в другом случае.
        */

        String login = "Default_Login";
        String password = "Default_Password123";
        String confirmPassword = "Default_Password123";
        if (args.length == 3){
            login = args[0];
            password = args[1];
            confirmPassword = args[2];
        }

        System.out.println(authentification(login,password,confirmPassword));
    }
    public static boolean authentification(String login,String password, String confirmPassword) throws Exception{
        boolean auth = false;
        try {
            // используем регулярное выражение \w для проверки логина и пароля
            boolean loginCheck = Pattern.compile("\\w").matcher(login).find() && login.length()<20;
            boolean passwordCheck = Pattern.compile("\\w").matcher(password).find() && login.length()<20 && (password.equals(confirmPassword));
            if (loginCheck && passwordCheck) {
                auth = true;
                System.out.println("You authorizated!");
            }
            else if (!loginCheck) {
                throw new WrongLoginException();
            }
            else if(!passwordCheck) {
                throw new WrongPasswordException();
            }
        }
        catch (WrongLoginException LoginException){
            auth = false;
            System.out.println("ERR: "+ LoginException.getMessage());
        }
        catch (WrongPasswordException PasswordException){
            auth = false;
            System.out.println("ERR: "+ PasswordException.getMessage());
        }
        finally {
            return auth;
        }
    }

    static class WrongLoginException extends Exception{
        WrongLoginException(){
            super("Wrong login!");
        }
        WrongLoginException(String message){
            super(message);
        }
    }
    static class WrongPasswordException extends Exception{
        WrongPasswordException(){
            super("Wrong password!");
        }
        WrongPasswordException(String message){
            super(message);
        }
    }
}