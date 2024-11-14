
@FunctionalInterface
public interface DevisionOn<T extends Number> {
    /**
     * Предикант, получает число, возвращает бул
     * @param t число
     * @return булевое значение
     */
    boolean pred(T t);
}