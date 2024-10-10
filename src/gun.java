public class gun extends weapon implements shooting {

    private int magazineSize = 1;
    private int ammo = 1;
    gun(){
        super("Gun");
    }
    gun(String name) {
        super(name);
    }

    gun(String name, int damage) {
        super(name, damage);
    }

    gun(String name, int damage, int magazineSize) {
        super(name);
        setDamage(damage);
        this.magazineSize = magazineSize;
        this.ammo = magazineSize;
    }
    @Override
    public void displayInfo(){
        System.out.printf("Name: %s, Damage: %d, id: %d, MagSize:%d, Ammo: %d\n",getName(),getDamage(),getId(),getMagazineSize(),getAmmo());
    }
    @Override
    public int attack(player attacker, player prey) { //переопределяем функцию из класса родителя различие в выводе в else
        if (((getDamage() >= prey.getHealthPoint()) & getAmmo()>0) | prey.getLive()==false) {
            setAmmo(getAmmo()-1);//прозводим выстрел
            prey.setLive(false);
            prey.setHealthPoint(0);
            System.out.printf("Player \"%s\" KILL player \"%s\"(%dhp) by %d damage using \"%s\"(%d/%d)\n", attacker.getName(), prey.getName(), prey.getHealthPoint(), getDamage(), getName(),getAmmo(),getMagazineSize());
            return 1;//если убил, то возвращает 1
        } else if ((getDamage() < prey.getHealthPoint()) & getAmmo()>0){
            setAmmo(getAmmo()-1);
            prey.setHealthPoint(prey.getHealthPoint() - getDamage());
            System.out.printf("Player \"%s\" SHOOT player \"%s\"(%dhp) by %d damage using \"%s\"(%d/%d)\n", attacker.getName(), prey.getName(), prey.getHealthPoint(), getDamage(), getName(),getAmmo(),getMagazineSize());
            return 0;// если ранил, то 2
        }
        else {
            System.out.println("NoAmmo!");
            return 2; //если осечка, то 0
        }
    }

    @Override
    public int shoot(player attacker, player prey) {//переопределяем функцию из интерфейса
        return attack(attacker, prey);
    }

    @Override
    public void reload() {//переопределяем функцию из интерфейса для использования protected функций
        setAmmo(getMagazineSize());
        System.out.printf("%s reload!\n",getName());

    }

    public void remade(String name,int damage,int magazineSize){// переделка класса используя protected функции
        setDamage(damage);
        setName(name);
        setMagazineSize(magazineSize);
    }

    protected void setAmmo(int ammo) {// используется только для перезарядки(reload)
        if (ammo>0 & ammo<=getMagazineSize()) {
            this.ammo = ammo;
        }
        else {
            this.ammo = 0;
        }
    }

    public int getAmmo() {
        return ammo;
    }

    protected void setMagazineSize(int magazineSize) { // используется для remade
        if (magazineSize > 0) {
            this.magazineSize = magazineSize;
        }
    }

    protected int getMagazineSize() {
        return magazineSize;
    }
}
