
import java.util.random.RandomGenerator;

public class Main {
    /**
     * Это основной метод, использующий методы классов.
     * @param args Не используется.
     */
    public static void main(String[] args) {
        /**
         * Я как обычно лишний раз замарочился
         * пополнение List'a со студентами пополсянется несколькими способами.
         * Либо мы передаем параметры в функцию и внутри этой функции создается объект класса Students и помещается
         * в List или мы передаем сам объект класса Students и внутри
         */
        DeanOffice dean = new DeanOffice();
        String[] subjects = {"Русский", "Математика", "Информатика"};
        dean.addStudentInStudentDataBase("Аня", "ИТСС", 1, subjects, new int[] {2,2,3});
        dean.addStudentInStudentDataBase("Глеб", "ЖТО", 2, subjects, new int[] {3,3,3});
        dean.addStudentInStudentDataBase("Боря", "ЖТО", 3, subjects, new int[] {4,4,3});
        dean.addStudentInStudentDataBase("Ира", "ИТСС", 3, subjects, new int[] {5,5,5});

        dean.printAllStudents();
        System.out.println("Студенты 3-го курса");
        dean.printStudents(dean.getStudentDataBase(),3);
        System.out.println("Удаляем " + dean.delBadStudents() + " студентов, со средним баллом <3.");
        dean.printAllStudents();
        System.out.println("Переводим " + dean.transferToOlderCourse() + " студентов со средним балом >=3 на курс старше");
        dean.printAllStudents();
    }
}
