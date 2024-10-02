
public abstract class entity {
    private String name = "Entity";
    private int healthPoint = 100;

    static int counter = 1;
    private int id = counter;
    entity.coords cord = new entity.coords();

    entity() {
    }

    entity(String name) {
        this.name = name;
        this.healthPoint = healthPoint;
    }

    entity(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    entity(String name, int healthPoint) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.healthPoint = healthPoint;
    }

    entity(int posX, int posY) {
        cord.setPosX(posX);
        cord.setPosY(posY);
    }

    entity(String name, int posX, int posY) {
        this.name = name;
        cord.setPosX(posX);
        cord.setPosY(posY);
    }

    entity(String name, int healthPoint, int posX, int posY) {
        this.name = name;
        this.healthPoint = healthPoint;
        cord.setPosX(posX);
        cord.setPosY(posY);
    }

    //ИНКАПСУЛИРОВАННЫЙ класс координат
    protected class coords {
        private int posY;
        private int posX;

        coords() {
            this.posX = 0;
            this.posY = 0;
        }

        coords(int x, int y) {
            this.posX = x;
            this.posY = y;
        }
        public void changePos(int x,int y){
            setPosX(x);
            setPosY(y);
        }
        public int getPosX() {
            return posX;
        }

        private void setPosX(int posX) {
            this.posX = posX;
        }

        public int getPosY() {
            return posY;
        }

        private void setPosY(int posY) {
            this.posY = posY;
        }
    }

    //Абстрактная функция
    public abstract void printInfo();

    public int getId() {
        return id;
    }

    public static void displayCounter() {

        System.out.printf("Counter: %d \n", counter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    protected void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

}
