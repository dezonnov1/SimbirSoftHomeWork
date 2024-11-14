/**
 * Класс Main, который использует функции классов в проекте для демонстрации выполненного задания.<br>
 *
 *  1. Добавить в классовую модель из домашнего задания 1 (или написать новую модель)
 * примеры использования дженерик-классов (обобщенных типов) и дженерик-интерфейсов.<br>
 *
 * 2. Написать функциональный интерфейс с методом, который принимает число и возвращает
 * булево значение. Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает
 * true если переданное число делится без остатка на 13.<br>
 *
 * 3. Написать функциональный интерфейс с методом, который принимает три дробных числа: a, b, c и
 * возвращает тоже дробное число. Написать реализацию такого интерфейса в виде лямбда-выражения,
 * которое возвращает дискриминант. Кто забыл, D = b^2 — 4ac.
 */
public class Main {
    /**
     * Это основной метод, использующий методы классов.
     * @param args Не используется.
     */
    public static void main(String[] args) {
        // (1)
        Table<String> stol1 = new Table<>("ТаблЭтка");
        /*Воруем таблЭтку*/
        System.out.println( "Что своровали со стола stol1 " + stol1.stealItem() ); // ТаблЭтка
        /*А сейчас ничего не получим*/
        System.out.println( "Что своровали со стола stol1 " + stol1.stealItem() ); // null

        /*Тут такая же картина.*/
        Table<Integer> stolInt = new Table<>(52);
        System.out.println( "Что своровали со стола stolInt " + stolInt.stealItem() ); // 52
        System.out.println( "Что своровали со стола stolInt " + stolInt.stealItem() ); // null

        // (2)
        int testI =24;
        double testD =26.0;

        DevisionOn<Integer> devisionOn13I = x-> (x % 13) == 0;
        System.out.println("Результат при " + testI + " % 26 = " + devisionOn13I.pred(testI));

        // делаем диапазон для из-за погрешности округления
        DevisionOn<Double> devisionOn13D = x-> (-0.0001 < (x % 13)) && ((x % 13) < 0.0001);
        System.out.println("Результат при " + testD + " % 26 = " + devisionOn13D.pred(testD));

        // (3)
        double a = 1.0;
        double b = 2.0;
        double c = 1.0;

        Discriminant<Double> discriminant = (la, lb, lc) -> (lb*lb-4*la*lc);
        System.out.println(String.format(("a = %.02f, b = %.02f, c = %.02f, D = %.02f"),a,b,c,discriminant.sup(a,b,c)));
        a = 2.4;
        b = 7.2;
        c = 3.2;
        System.out.println(String.format(("a = %.02f, b = %.02f, c = %.02f, D = %.02f"),a,b,c,discriminant.sup(a,b,c)));
    }
}
