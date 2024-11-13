/**Класс оружия<br>
 * Имеет методы нанесения урона и убийства объектов класса player*/

public class weapon implements modificate {

    private String name;
    private int damage;
    static int counter = 1;
    private int id = counter;
    /**Конструктор по умолчанию*/
    weapon() {
        this("Weapon");
    }
    /**Конструктор
     * @param name имя*/
    weapon(String name) {
        this(name,1);
    }
    /**Конструктор
     * @param name имя
     * @param damage урон*/
    weapon(String name, int damage) {
        this.id = counter++;
        this.name = name;
        this.damage = damage;
    }
    /**Вывод информации о классе*/
    public void displayInfo(){
        System.out.printf("Name: %s, Damage: %d, id: %d\n",getName(),getDamage(),getId());
    }
    /**Выводит состояние счетчика*/
    public static void displayCounter() {

        System.out.printf("Counter: %d \n", counter);
    }
    /**Атака игрока оружием
     * @param attacker класс Player атакующий
     * @param prey класс Player жертва
     * @return "1" если убил или "0" если ранил*/
    public int attack(player attacker, player prey) {
        if (getDamage() >= prey.getHealthPoint()) {
            prey.setLive(false);
            prey.setHealthPoint(0);
            System.out.printf("Player \"%s\" KILL player \"%s\" by %d damage using \"%s\"\n", attacker.getName(), prey.getName(), getDamage(), getName());
            return 1;//если убил, то возвращает 1
        } else {
            prey.setHealthPoint(prey.getHealthPoint() - getDamage());// вычитаем из нынешнего HP вычитаем урон оружия.
            System.out.printf("Player \"%s\" HURT player \"%s\" by %d damage using \"%s\"\n", attacker.getName(), prey.getName(), getDamage(), getName());
            return 0;// если ранил, то 0
        }
    }

    @Override
    public void rename(String name) {
        this.name = name;
    }

    @Override
    public void remade(String name,int damage){//переопределяем функцию из интерфейса для использования protected функций
        setDamage(damage);
        setName(name);
    }
    /**Гетер урона
     * @return кол-во уроа*/
    public int getDamage() {
        return damage;
    }
    /**Сетер урона<br>
     * Защищенный, для использования в функции attack
     * @param damage урон*/
    protected void setDamage(int damage) {
        this.damage = damage;
    }
    /**Сетер имени
     * @param name имя*/
    protected void setName(String name) {
        this.name = name;
    }
    /**Гетер имени
     * @return имя*/
    public String getName() {
        return name;
    }
    /**Гетер ID
     * @return ID*/
    public int getId() {
        return id;
    }
}
