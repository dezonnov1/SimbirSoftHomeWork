import java.util.*;
import java.util.random.RandomGenerator;

/**
 * Этот класс Деканат нужен для управления студентами.
 */
public class DeanOffice {
    private List<Students> studentDataBase = new ArrayList<>();

    DeanOffice(){}

    /**
     * Случайное заполнение имен и групп студентов
     * @param countRandomStudents Количество студентов, сгененрированых псевдослучайно.
     * @param groupCount Количество групп студентов.
     * @param subjects Предметы курса.
     */
    DeanOffice(int countRandomStudents,  int groupCount, String[] subjects){
        for (int i = 0; i < countRandomStudents; i++){
            Map<String, Integer> mapEvaluations = new HashMap<>();
            for (String str : subjects){
                mapEvaluations.put(str, RandomGenerator.getDefault().nextInt(2,6));
            }

            Students student = new Students("student #"+i,
                    "group #"+RandomGenerator.getDefault().nextInt(groupCount+1),
                    RandomGenerator.getDefault().nextInt(1,7),
                    mapEvaluations);
        }
    }

    /**
     * По умолчанию групп 3.
     * @param countRandomStudents Количество студентов, сгененрированых псевдослучайно.
     * @param subjects Предметы курса.
     */
    DeanOffice(int countRandomStudents, String[] subjects){
        for (int i = 0; i < countRandomStudents; i++){
            Map<String, Integer> mapEvaluations = new HashMap<>();
            // заполняем Map случайными оценками
            for (String str : subjects){
                mapEvaluations.put(str, RandomGenerator.getDefault().nextInt(2,6));
            }

            Students student = new Students("student #"+i,
                    "group #"+RandomGenerator.getDefault().nextInt(4),
                    RandomGenerator.getDefault().nextInt(1,7),
                    mapEvaluations );
            addStudentInStudentDataBase(student);
        }
    }

    /**
     * @param countRandomStudents Количество студентов, сгененрированых псевдослучайно.
     * @param names массив имен. Из него будет случайно браться имена для студентов.
     * @param groups массив груп. Из него будет случайно браться названия групп для студентов.
     * @param courses массив номеров курса. Из него будет случайно браться номера для определения курса студента.
     * @param subjects массив предметов. Из него будет случайно браться названия предметов для студента.
     */
    DeanOffice(int countRandomStudents, String[] names, String[]groups, int[]courses, String[] subjects){
        for (int i = 0; i < countRandomStudents; i++){
            Map<String, Integer> mapEvaluations = new HashMap<>();
            // заполняем Map случайными оценками
            for (String str : subjects){
                mapEvaluations.put(str, RandomGenerator.getDefault().nextInt(2,6));
            }
            Students student = new Students(names[RandomGenerator.getDefault().nextInt(names.length)],
                    groups[RandomGenerator.getDefault().nextInt(groups.length)],
                    courses[RandomGenerator.getDefault().nextInt(groups.length)],
                    mapEvaluations);
            addStudentInStudentDataBase(student);
        }
    }

    /**
     * Генерирует countRandomStudents студентов.
     * @param countRandomStudents Количество студентов, сгененрированых псевдослучайно.
     * @param names массив имен. Из него будет случайно браться имена для студентов.
     * @param groups массив груп. Из него будет случайно браться названия групп для студентов.
     * @param courses массив номеров курса. Из него будет случайно браться номера для определения курса студента.
     * @param subjects массив предметов. Из него будет случайно браться названия предметов для студента.
     * @param estimations массив оценок. Из него будет случайно браться оценки по предметам студента.
     */
    DeanOffice(int countRandomStudents, String[] names, String[]groups, int[]courses,
               String[] subjects, int[] estimations)
    {
        for (int i = 0; i < countRandomStudents; i++){
            Students student = new Students(names[RandomGenerator.getDefault().nextInt(names.length)],
                    groups[RandomGenerator.getDefault().nextInt(groups.length)],
                    courses[RandomGenerator.getDefault().nextInt(groups.length)],
                    subjects,estimations);
            studentDataBase.add(student);
        }
    }

    public void setStudentDataBase(ArrayList<Students> studentDataBase){
        this.studentDataBase = studentDataBase;
    }
    /**
     * Добавить объект студент в базу данных.
     * @param student объект студент.
     */
    public void addStudentInStudentDataBase(Students student){
        this.studentDataBase.add(student);
    }

    /**
     * Добавить студента по имени, группе, курсу, предметам.
     * @param name имя студента.
     * @param group группа студента.
     * @param course номер курса.
     * @param subjects предметы студента.
     */
    public void addStudentInStudentDataBase(String name, String group, int course, String[] subjects){
        Students student = new Students(name, group, course, subjects);
        addStudentInStudentDataBase(student);
    }
    public void addStudentInStudentDataBase(String name, String group, int course, String[] subjects, int[] estimations){
        Students student = new Students(name, group, course, subjects, estimations);
        addStudentInStudentDataBase(student);
    }

    /**
     * Получение массива студентов.
     * @return список студентов.
     */
    public List<Students> getStudentDataBase(){
        return studentDataBase;
    }

    /**
     * Функция, которя удаляет студентов со средним баллом <3.
     * @return количество удаленных студентов из списка. Или -1 если список студентов пуст
     */
    public int delBadStudents(){
        return delBadStudents(studentDataBase);
    }

    /**
     * Функция, которя удаляет студентов со средним баллом <3.
     * @param studs Список студентов
     * @return количество удаленных студентов из списка. Или -1 если список студентов пуст
     */
    public int delBadStudents(List<Students> studs){
        if (studs.isEmpty()){
            return -1;
        }
        int SizeStudentDB = studs.size();
        List<Students> temp = new ArrayList<>();
        for (Students stud : studs){
            int sum = 0;
            if (stud.getEvaluations().isEmpty()) { //если у студента нет оценок, то его в temp не добавляем
                continue; //Скипаем к следующему
            }
            for (Integer it : stud.getEvaluations().values()) {
                sum += it;
            }
            if (sum / stud.getEvaluations().size() >= 3) {
                /*здесь catch на деление на ноль не нужен,
            ибо в первом if мы исключаем пустой список*/
                temp.add(stud);
            }
        }
        studs = new ArrayList<>(temp);
        return SizeStudentDB - temp.size();
    }


    /**
     * Могут перевестись на курс старше
     * @param studs Список студентов
     * @return количество студентов которые перевелись. Или -1 если список студентов пуст
     */
    public int transferToOlderCourse(List<Students> studs){
        if (studs.isEmpty()){
            return -1;
        }
        int promotedStudents = 0;
        for (Students stud : studs){
            int sum = 0;
            if (stud.getEvaluations().isEmpty()) { //если у студента нет оценок, то его в temp не добавляем
                continue; //Скипаем к следующему
            }
            for (Integer it : stud.getEvaluations().values()) {
                sum += it;
            }
            if (sum / stud.getEvaluations().size() >= 3) {
                /*здесь catch на деление на ноль не нужен,
            ибо в первом if мы исключаем пустой список*/
                stud.setCourse(stud.getCourse()+1);
                promotedStudents++;
            }
        }
        return promotedStudents;
    }
    /**
     * Могут перевестись на курс старше
     * @return количество студентов которые могут перевестись. Или -1 если список студентов пуст
     */
    public int transferToOlderCourse(){
        return transferToOlderCourse(studentDataBase);
    }
    public void printStudents(List<Students>students, int course){
        for (Students stud: students){
            if (stud.getCourse()==course){
                System.out.println(stud.getName() + " | "+stud.getCourse() + " | "+stud.getGroup() + " | " + stud.getStringEvaluations());
            }
        }
    }


    public void printAllStudents(){
        for (Students stud: this.getStudentDataBase()){
                System.out.println(stud.getName() + " | "+stud.getCourse() + " | "+stud.getGroup() + " | " + stud.getStringEvaluations());
        }
    }
}
