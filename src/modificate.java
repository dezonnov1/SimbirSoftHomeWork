/**Интерфейс для модификации класса оружия*/
public interface modificate {
    /**Переименовывание объекта
     * @param name имя*/
    public void rename(String name);
    /**Переделка объекта
     * @param name имя
     * @param damage урона*/
    public void remade(String name,int damage);
}
