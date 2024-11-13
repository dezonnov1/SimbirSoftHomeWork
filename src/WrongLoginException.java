/**
 * Пользовательский класс ошибки для обозначения неверного логина
 */
public class WrongLoginException extends Exception {
  public WrongLoginException() {
      super();
    }
  public WrongLoginException(String message) {
    super(message);
  }
}
