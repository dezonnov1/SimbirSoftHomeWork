public class player extends entity {
    // наследуемся от абстрактного класса entity
    private Boolean isLive = true; // состояние жизни у игрока

    player() {
        super("Player");
    }

    player(String name) {
        super(name);
    }

    player(String name, int posX, int posY) {
        super(name);
    }

    player(String name, int healthPoint) {
        super(healthPoint);
        setName(name);
    }

    public void setPos(int x, int y) {
        cord.changePos(x,y);
    }

    public int[] getPos() {
        int posX = cord.getPosX();
        int posY = cord.getPosY();
        int[] arr = {posX, posY};
        System.out.printf("player \"%s\" has posX: %d | posY: %d\n", getName(), posX, posY);
        return arr;
    }

    protected void setHealthPoint(int healthPoint) {
        super.setHealthPoint(healthPoint);
    }

    @Override
    public void printInfo() { // переопределяем функцию из абстрактного класса
        System.out.printf("Player \"%s\", posX: %d, posY: %d, Hp: %d, is live: %s\n", getName(), cord.getPosX(), cord.getPosY(), getHealthPoint(), getLive());
        // в стоит ли дальше использовать в подобных функицях get'ры и set'ры этого же класса? Отпишите пожалуйста!
    }

    public int attack(weapon wp, player prey) {
        //атакуем жертву(prey) используя оружие(wp)
        return wp.attack(this, prey);
    }

    public Boolean getLive() {
        return isLive;
    }

    public void setLive(Boolean live) {
        isLive = live;
    }

}
