/**Класс огнестрельного оружия
 * добавляется размер магазина*/

public class gun extends weapon implements shooting {
    /**Размер магазина*/
    private int magazineSize = 1;
    /**Патронов в оружии*/
    private int ammo = 1;
    /**Конструктор по умолчанию*/
    gun(){
        super("Gun");
    }
    /**Конструктор
     * @param name имя*/
    gun(String name) {
        super(name);
    }
    /**Конструктор
     * @param name имя
     * @param damage урон*/
    gun(String name, int damage) {
        super(name, damage);
    }
    /**Конструктор
     * @param name имя
     * @param damage урон
     * @param magazineSize размер магазина*/
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
        if (((getDamage() >= prey.getHealthPoint()) & getAmmo()>0) | prey.getLive() == false) {
            setAmmo(getAmmo()-1);//прозводим выстрел
            prey.setLive(false);
            prey.setHealthPoint(0);
            System.out.printf("Player \"%s\" KILL player \"%s\"(%dhp) by %d damage using \"%s\"(%d/%d)\n",
                    attacker.getName(), prey.getName(), prey.getHealthPoint(), getDamage(), getName(),getAmmo(),getMagazineSize());
            return 1;//если убил, то возвращает 1
        }

        else if ((getDamage() < prey.getHealthPoint()) & getAmmo()>0){
            setAmmo(getAmmo()-1);
            prey.setHealthPoint(prey.getHealthPoint() - getDamage());
            System.out.printf("Player \"%s\" SHOOT player \"%s\"(%dhp) by %d damage using \"%s\"(%d/%d)\n",
                    attacker.getName(), prey.getName(), prey.getHealthPoint(), getDamage(), getName(),getAmmo(),getMagazineSize());
            return 0;// если ранил, то 0
        }

        else {
            System.out.println("NoAmmo!");
            return 2; //если осечка, то 2
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
    /**Переделка объекта
     * @param name имя
     * @param damage урон
     * @param magazineSize размер магазина
     */
    public void remade(String name,int damage,int magazineSize){
        setDamage(damage);
        setName(name);
        setMagazineSize(magazineSize);
    }
    /**Сетер патронов, используется для метода <b>reload</b>
     * @param ammo кол-во патронов*/
    protected void setAmmo(int ammo) {
        if (ammo>0 & ammo<=getMagazineSize()) {
            this.ammo = ammo;
        }
        else {
            this.ammo = 0;
        }
    }
    /**Гетер патронов
     * @return количество патронов*/
    public int getAmmo() {
        return ammo;
    }
    /**Сетер размера магаина, используется в методе <b>remade</b>
     * @param magazineSize размер магазина*/
    protected void setMagazineSize(int magazineSize) { // используется для remade
        if (magazineSize > 0) {
            this.magazineSize = magazineSize;
        }
    }
    /**Гетер размера магазина
     * @return размер магазина*/
    public int getMagazineSize() {
        return magazineSize;
    }
}
