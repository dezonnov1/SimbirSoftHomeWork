/**Интерфейс для взаимодействия с огнестрельным оружием*/
public interface shooting {
    /**
     * Выстрел
     * @param attacker атакующий
     * @param prey жертва
     * @return состояние попадания
     */
    public int shoot(player attacker, player prey);

    /**
     * перезарядка
     * */
    public void reload();
}
