/** Класс main
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
public class Main {
    public static void main(String[] args) throws Exception {
        String login = "Default_Login";
        String password = "Default_Pыassword23";
        String confirmPassword = "Default_Password123";
        if (args.length == 3){
            login = args[0];
            password = args[1];
            confirmPassword = args[2];
        }
        System.out.println("Состояние вашей авторизации: "+Account.authentification(login,password,confirmPassword));
    }
}
