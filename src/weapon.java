public class weapon{
    // это класс орижия
    // оно способно наносить урон игроку (player)
    // и имеет радиус применения
    private String name = "weapon";
    private int damage = 0;
    private float range = 0;
    static int id = 1;



    public boolean hit(){
        return false;
    };

    weapon(String name){
        this.name = name;
    }
    
    weapon(String name,float range){
        this.name = name;
        this.range =range;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getId() {
        return id;
    }

}