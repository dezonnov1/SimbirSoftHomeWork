/**Класс пистолета пулемета*/

public class smg extends gun {
    mode fireMode = mode.AUTO;

    /**Enum для определения режима стрельбы*/
    enum mode {
        SEMI,
        AUTO
    }
    /**Конструктор по умолчанию*/
    smg() {
        super("Smg");
    }

    /**Конструктор
     * @param name имя*/
    smg(String name) {
        super(name);
    }
    /**Конструктор
     * @param name имя
     * @param damage урон*/
    smg(String name, int damage) {
        super(name, damage);
    }
    /**Конструктор
     * @param name имя
     * @param damage урон
     * @param magazineSize размер магазина*/
    smg(String name, int damage, int magazineSize) {
        super(name, damage, magazineSize);
    }
    /**Конструктор
     * @param name имя
     * @param strFireMode режим стрельбы "semi" / "auto"*/
    smg(String name, String strFireMode) {
        super(name);
        switch (strFireMode) {
            case "semi": this.fireMode = mode.SEMI; break;
            case "auto": this.fireMode = mode.AUTO; break;
        }
    }
    /**Конструктор
     * @param name имя
     * @param damage урон
     * @param strFireMode режим стрельбы "semi" / "auto"*/
    smg(String name, int damage, String strFireMode) {
        super(name, damage);
        switch (strFireMode) {
            case "semi": this.fireMode = mode.SEMI; break;
            case "auto": this.fireMode = mode.AUTO; break;
            default: this.fireMode = mode.AUTO; break;
        }
    }
    /**Конструктор
     * @param name имя
     * @param damage урон
     * @param magazineSize размер магазина
     * @param strFireMode режим стрельбы "semi" / "auto"*/
    smg(String name, int damage, int magazineSize, String strFireMode) {
        super(name, damage,magazineSize);
        switch (strFireMode) {
            case "semi": this.fireMode = mode.SEMI; break;
            case "auto": this.fireMode = mode.AUTO; break;
            default: this.fireMode = mode.AUTO; break;
        }
    }

    /**
     * Смена режима стрельбы
     * @param strFireMode режим стрельбы "semi" / "auto"
     */
    public void ChangeFireMode(String strFireMode){
        switch (strFireMode) {
            case "semi": this.fireMode = mode.SEMI; break;
            case "auto": this.fireMode = mode.AUTO; break;
            default: this.fireMode = mode.AUTO; break;
        }
    }

    @Override
    public void displayInfo(){
        String mode="";
        switch (fireMode) {
            case SEMI: mode = "semi"; break;
            case AUTO: mode = "auto"; break;
        }
        System.out.printf("Name: %s, Damage: %d, id: %d, MagSize:%d, Ammo: %d, Mode: %s\n",
                getName(),getDamage(),getId(),getMagazineSize(),getAmmo(),mode);
    }

    /**
     * Атака
     * @param attacker класс Player атакующий
     * @param prey класс Player жертва
     * @return состояние атаки из <b>gun</b>
     */

    @Override
    public int attack(player attacker, player prey) {//переопределяем функцию из интерфейса
        switch (fireMode) {
            case SEMI: return attack(attacker, prey);
            case AUTO:
                int temp = 0;
                while (temp == 0){// стреляем пока наносим урон
                    temp = super.attack(attacker, prey);
                }
                return temp;
            default: return attack(attacker, prey);
        }
    }
}
