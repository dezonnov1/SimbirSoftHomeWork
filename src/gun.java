public class gun extends weapon implements shooting, modificate{

    private int magazineSize = 0;
    private int ammo = 0;


    gun(String name,float range){
        super(name,range);
    }

    gun(String name,float range, int magazineSize){
        super(name,range);
        this.magazineSize = magazineSize;
    }

    public void shoot(){
        if (ammo>0){
            ammo -= 1;
            System.out.println("BANG!");
        }
        else {
            System.out.println("Cinn...");
        }
    }


    public void reload(){
        if(this.ammo>0 & magazineSize>0) {
            setAmmo(this.magazineSize);
            System.out.println("reload success");
        }
        else{
            System.out.println("reload fail");
        }
    }

    public void mod() {

    }

    protected void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    protected void setMagazineSize(int magazineSize) {
        if (magazineSize>0) {
            this.magazineSize = magazineSize;
        }
    }

    protected int getMagazineSize() {
        return magazineSize;
    }
}
