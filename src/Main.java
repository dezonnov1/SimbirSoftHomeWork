/**
 * Класс Main, который использует функции классов в проекте для демонстрации выполненного задания.<br>
 * ✅ иррархия <b>weapon</b> -> <b>gun</b> -> <b>smg</b> получается 2 потомка<br>
 * ✅ 2 интерфейса и каждый из них реализован(из <b>shooting</b> в <b>gun</b>, а из <b>modificate</b> в <b>weapon</b>)<br>
 * ✅ абстрактный класс entity c абстрактной функцией printInfo()<br>
 * ✅ КАЖДЫЙ класс содержит >2 полей<br>
 * ✅ в каждом классе есть параметризированный конструктор<br>
 * ✅ реализация инкапсуляции в entity, класс coords, где сеттеры posX posY являются private<br>
 * ✅ статическое поле и метод в entity, counter и displayCounter()<br>
 * ✅ методы в каждом классе<br>
 * ✅ методы реализовывают какую-то сложную логику<br>
 */
public class Main {
    /**
     * Это основной метод, использующий методы классов.
     * @param args Не используется.
     */
    public static void main(String[] args) {


        // у нас есть игрок и оружие
        player Bob = new player("Bob");
        Bob.printInfo();

        player BigBob = new player("Big Bob", 200);
        Bob.printInfo();
        // printInfo и displayInfo это по сути выполняют одно и тоже, но printInfo это унаследованный от абстрактного класса
        weapon axe = new weapon("axe", 19);
        axe.displayInfo();

        gun pistol = new gun("p250", 14,10);
        pistol.displayInfo();

        smg p90 = new smg("P90",27,50,"auto");
        p90.displayInfo();

        Bob.printInfo();
        BigBob.printInfo();
        System.out.println("Сущности созданы и получена информация о них\n");

        Bob.attack(pistol, BigBob);
        BigBob.printInfo();
        System.out.println("О нееет! Bob стреляет в BigBob'a!\n");

        Bob.attack(axe, BigBob);
        BigBob.printInfo();
        System.out.println("Ужас!!! Bob бьёт BigBob'a топором!\n");

        if(!BigBob.getLive()){
            BigBob.setHealthPoint(200);
            BigBob.setLive(true);
            BigBob.printInfo();
            System.out.println("Возвращаем BigBob'a к жизни\n");
        }
        else {
            BigBob.printInfo();
            System.out.println();
        }

        p90.ChangeFireMode("semi");

        Bob.attack(p90, BigBob);
        BigBob.printInfo();
        System.out.println("О нееет! Bob расстреливает BigBob'a!\n");
    }
}
