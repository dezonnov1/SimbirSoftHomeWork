public class smg extends gun {
    mode fireMode = mode.AUTO;

    enum mode {
        SEMI,
        AUTO
    }

    smg() {
        super("Smg");
    }

    smg(String name) {
        super(name);
    }

    smg(String name, int damage) {
        super(name, damage);
    }

    smg(String name, int damage, int magazineSize) {
        super(name, damage, magazineSize);
    }

    smg(String name, String strFireMode) {
        super(name);
        switch (strFireMode) {
            case "semi": this.fireMode = mode.SEMI; break;
            case "auto": this.fireMode = mode.AUTO; break;
        }
    }

    smg(String name, int damage, String strFireMode) {
        super(name, damage);
        switch (strFireMode) {
            case "semi": this.fireMode = mode.SEMI; break;
            case "auto": this.fireMode = mode.AUTO; break;
        }
    }

    smg(String name, int damage, int magazineSize, String strFireMode) {
        super(name, damage,magazineSize);
        switch (strFireMode) {
            case "semi": this.fireMode = mode.SEMI; break;
            case "auto": this.fireMode = mode.AUTO; break;
        }
    }
    @Override
    public void displayInfo(){
        String mode="";
        switch (fireMode) {
            case SEMI: mode = "semi"; break;
            case AUTO: mode = "auto"; break;
        }
        System.out.printf("Name: %s, Damage: %d, id: %d, MagSize:%d, Ammo: %d, Mode: %s\n",getName(),getDamage(),getId(),getMagazineSize(),getAmmo(),mode);
    }
    @Override
    public int attack(player attacker, player prey) {//переопределяем функцию из интерфейса
        switch (fireMode) {
            case SEMI: return attack(attacker, prey);
            case AUTO:
                int temp = 0;
                while (temp == 0){// стреляем пока не кончатся патроны, или не умрет цель
                    temp = super.attack(attacker, prey);
                }
                return temp;

            default: return attack(attacker, prey);
        }
    }

}
