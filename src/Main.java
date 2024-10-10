public class Main {
    public static void main(String[] args) {
        /*✅ иррархия weapon -> gun -> smg получается 2 потомка
        //✅ 2 интерфейса и каждый из них реализован(shooting в gun, а modificate в weapon)
        //✅ абстрактный класс entity c абстрактной функцией printInfo()
        //✅ КАЖДЫЙ класс содержит >2 полей
        //✅ в каждом классе есть параметризированный конструктор
        //✅ реализация инкапсуляции в entity, класс coords, где сеттеры posX posY являются private
        //✅ статическое поле и метод в entity, counter и displayCounter()
        //✅ методы в каждом классе
        //✅ методы реализовывают какую-то сложную логику
        */

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
        System.out.println("Сущности созданны и получена информация о них\n");

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



        Bob.attack(p90, BigBob);
        BigBob.printInfo();
        System.out.println("О нееет! Bob расстреливает BigBob'a!\n");

    }
}