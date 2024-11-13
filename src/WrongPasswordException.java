/**
 * Пользовательский класс ошибки для обозначения неверного пароля
 */
public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }
    public WrongPasswordException(String message) {
        super(message);
    }
}
