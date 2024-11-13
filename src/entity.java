/**
 * Класс Сущность
 * это класс родитель класса <b>player</b>
 */

public abstract class entity {
    /**Имя сущности*/
    private String name;
    /**Здоровье*/
    private int healthPoint;
    /**Счетчик*/
    static int counter = 1;
    /**Индификатор*/
    private int id = counter;
    entity.coords cord = new entity.coords();

    /**Конструктор по умолчанию*/
    entity() {
    }
    /**Конструктор
     * @param name имя сущности.
     * @return ничего.
     */
    entity(String name) {
        this(name,100,0,0);
    }
    /**Конструктор
     * @param healthPoint кол-во здоровья.
     * @return ничего.
     */
    entity(int healthPoint) {
        this("Entity",healthPoint,0,0);
    }
    /**Конструктор
     * @param name имя сущности.
     * @param healthPoint кол-во здоровья.
     * @return ничего.
     */
    entity(String name, int healthPoint) {
        this(name,healthPoint,0,0);
    }

    /**Конструктор
     * @param posX координаты по оси X.
     * @param posY координаты по оси Y.
     * @return ничего.
     */
    entity(int posX, int posY) {
        this("Entity",100,posX,posY);
    }

    /**Конструктор
     * @param name имя сущности.
     * @param posX координаты по оси X.
     * @param posY координаты по оси Y.
     * @return ничего.
     */
    entity(String name, int posX, int posY) {
        this(name,100,posX,posY);
    }

    /**Конструктор
     * @param name имя сущности.
     * @param healthPoint кол-во здоровья.
     * @param posX координаты по оси X.
     * @param posY координаты по оси Y.
     * @return ничего.
     */
    entity(String name, int healthPoint, int posX, int posY) {
        this.name = name;
        this.healthPoint = healthPoint;
        cord.setPosX(posX);
        cord.setPosY(posY);
    }

    /**Инкапсулированный класс координат для определения расположения сущности в 2D пространстве.
     * */
    protected class coords {
        private int posY;
        private int posX;
        /**Конструктор по умолчанию*/
        coords() {
            this(0,0);
        }
        /**Конструктор
         * @param x координаты по оси X.
         * @param y координаты по оси Y.*/
        coords(int x, int y) {
            this.posX = x;
            this.posY = y;
        }

        /**
         * Изменение координат
         * @param x ось X
         * @param y ось Y
         */
        public void changePos(int x,int y){
            setPosX(x);
            setPosY(y);
        }
        /**Гетер оси X
         * @return ось X*/
        public int getPosX() {
            return posX;
        }
        /**Сетер оси X
         * @param posX ось X*/
        public void setPosX(int posX) {
            this.posX = posX;
        }

        /**Гетер оси Y
         * @return ось Y*/
        public int getPosY() {
            return posY;
        }
        /**Сетер оси Y
         * @param posY ось Y*/
        public void setPosY(int posY) {
            this.posY = posY;
        }
    }

    /**Абстактная функция, для вывода информации о классе.*/
    public abstract void printInfo();
    /**Гетер ID
     * @return id */
    public int getId() {
        return id;
    }
    /**Статический метод отображения счетчика*/
    public static void displayCounter() {
        System.out.printf("Counter: %d \n", counter);
    }
    /**Гетер имени
     * @return имя*/
    public String getName() {
        return name;
    }
    /**Сетер имени
     * @param name имя*/
    public void setName(String name) {
        this.name = name;
    }
    /**Гетер здоровья
     * @return кол-во здоровья*/
    public int getHealthPoint() {
        return healthPoint;
    }
    /**Сетер кол-ва здоровья.<br>
     * <b>Protected</b> для внутреннего использования
     * @param healthPoint кол-во здоровья*/
    protected void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }
}
