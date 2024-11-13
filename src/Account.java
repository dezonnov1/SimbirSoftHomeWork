import java.util.regex.Pattern;

public class Account {
    static int counter =1;
    private int id = counter;



    private String name;

    /**
     * Конструктор по умолчанию
     */
    public Account(){
        this.name = "user";
    }

    /**
     * Конструктор с name
     * @param name имя пользователя
     */
    public Account(String name) {
        this.name = name;
    }

    /**
     * Геттер ID
     * @return ID пользователя
     */
    public int getId() {
        return id;
    }

    /**
     * Сетер
     * @param name имя пользователя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер
     * @return имя пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * Функция Аунтификации пользователя
     * @param login Длина должна быть меньше 20 символов и должен содержать только латинские буквы,
     *              цифры и знак подчеркивания.
     * @param password Длина должна быть меньше 20 символов и должен содержать только латинские буквы,
     *                 цифры и знак подчеркивания.
     * @param confirmPassword Должен быть равен <b>password</b> и длина должна быть меньше 20 символов,
     *                        должен содержать только латинские буквы, цифры и знак подчеркивания.
     * @return Boolean состояние авторизации
     * @throws WrongLoginException Выбрасывается если <b>login</b> длиннее 20 символов и содержит,
     *                               что-то кроме латинских букв, цифр и знаков подчеркивания.
     * @throws WrongPasswordException Выбрасывается если <b>password</b> и <b>confirmPassword</b> неравны и\или
     *                              длиннее 20 символов, содержит, что-то кроме латинских букв,
     *                              цифр и знаков подчеркивания.
     */
    public static boolean authentification(String login,String password, String confirmPassword) throws Exception{
        boolean auth = false;
        try {
            boolean loginCheck = Pattern.compile("[A-Za-z0-9]+").matcher(login).find() && login.length()<20;
            boolean passwordCheck = Pattern.compile("[A-Za-z0-9]+").matcher(password).find()
                    && login.length()<20 && (password.equals(confirmPassword));
            if (loginCheck && passwordCheck) {
                auth = true;
                System.out.println("You authorizated!");
            }
            else if (!loginCheck) {
                throw new WrongLoginException("Неверный логин!");
            }
            else if(!passwordCheck) {
                throw new WrongPasswordException("Неверный пароль!");
            }
        }
        catch (WrongLoginException | WrongPasswordException e){
            auth = false;
            System.out.println("ERR: "+ e.getMessage());
        }
        finally {
            return auth;
        }
    }
}
