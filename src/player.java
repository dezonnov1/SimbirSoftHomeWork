/**Класс Игрок, является наследником класса entity
 * <br>
 * Может использовать оружие */

public class player extends entity {
    // наследуемся от абстрактного класса entity
    /**Является ли игрок живым*/
    private Boolean isLive = true; // состояние жизни у игрока
    /**Конструктор по молчанию*/
    player() {
        super("Player");
    }
    /**Конструктор
     * @param name имя*/
    player(String name) {
        super(name,100,0,0);
    }
    /**Конструктор
     * @param name имя
     * @param posX ось X
     * @param posY ось Y
     * */
    player(String name, int posX, int posY) {
        super(name,100,posX,posY);
    }
    /**Конструктор
     * @param name имя
     * @param healthPoint кол-во здоровья
     * */
    player(String name, int healthPoint) {
        super(name,healthPoint,0,0);
    }
    /**Конструктор
     * @param name bvz
     * @param healthPoint кол-во здоровья
     * @param posX ось X
     * @param posY ось Y
     * */
    player(String name, int healthPoint, int posX, int posY) {
        super(name,healthPoint,posX,posY);
    }
    /**Гетер позиции
     * @return [posX, poxY]*/
    public int[] getPos() {
        int[] arrPos = {cord.getPosX(), cord.getPosY()};
        System.out.printf("player \"%s\" has posX: %d | posY: %d\n", getName(), arrPos[0], arrPos[1]);
        return arrPos;
    }

    @Override
    public void printInfo() { // переопределяем функцию из абстрактного класса
        System.out.printf("Player \"%s\", posX: %d, posY: %d, Hp: %d, is live: %s\n",
                getName(), cord.getPosX(), cord.getPosY(), getHealthPoint(), getLive());
    }
    /**Атака оружием
     * @param wp класс weapon оружие
     * @param prey класс player жертва
     * @return состояние атаки*/
    public int attack(weapon wp, player prey) {
        //атакуем жертву(prey) используя оружие(wp)
        return wp.attack(this, prey);
    }
    /**Гетер состояния здоровья
     *@return boolean статус здоровья*/
    public Boolean getLive() {
        return this.isLive;
    }
    /**Сетер состояния здоровья
     * @param live состояние жизни*/
    public void setLive(Boolean live) {
        this.isLive = live;
    }
}
