public class weapon implements modificate {
    // это класс оружия
    // оно способно наносить урон игроку (player)

    private String name = "weapon";
    private int damage = 1;
    static int counter = 1;
    private int id = counter;

    weapon() {
        this.id = counter++;
    }

    weapon(String name) {
        this.id = counter++;
        this.name = name;
    }

    weapon(String name, int damage) {
        this.id = counter++;
        this.name = name;
        this.damage = damage;
    }
    public void displayInfo(){
        System.out.printf("Name: %s, Damage: %d, id: %d\n",getName(),getDamage(),getId());
    }
    public static void displayCounter() {

        System.out.printf("Counter: %d \n", counter);
    }

    public int attack(player attacker, player prey) {
        if (getDamage() >= prey.getHealthPoint()) {
            prey.setLive(false);
            prey.setHealthPoint(0);
            System.out.printf("Player \"%s\" KILL player \"%s\" by %d damage using \"%s\"\n", attacker.getName(), prey.getName(), getDamage(), getName());
            return 1;//если убил, то возвращает 1
        } else {
            prey.setHealthPoint(prey.getHealthPoint() - getDamage());// вычитаем из нынешнего HP вычитаем урон оружия.
            System.out.printf("Player \"%s\" HURT player \"%s\" by %d damage using \"%s\"\n", attacker.getName(), prey.getName(), getDamage(), getName());
            return 0;// если ранил, то 2
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

    public int getDamage() {
        return damage;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}