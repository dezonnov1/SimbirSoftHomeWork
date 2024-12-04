import java.util.HashMap;
import java.util.Map;
import java.util.random.RandomGenerator;

/**
 * Класс Студент/<br>
 * Содержит имя, номер курса, название группы, и map оценок(по пятибальной системе(2,3,4,5)).
 * */
public class Students {
    private String name;
    private Map<String, Integer> evaluations = new HashMap<String, Integer>();
    private String group;
    private int course;

    Students(){
        this.name = "";
        this.group = "";
        this.course = 1;
    }

    Students(int course, Map<String, Integer> evaluations){
        this("","",1,evaluations);
    }

    Students(String name, String group, int course, String[] subjects) {
        this.name = name;
        this.group = group;
        this.course = course;
        setEvaluations(subjects);
    }
    Students(String name, String group, int course, String[] subjects, int[] estimations){
        this.name = name;
        this.group = group;
        this.course = course;
        setEvaluations(subjects,estimations);
    }

    Students(String name, String group, int course, Map<String, Integer> evaluations){
        this.name = name;
        this.group = group;
        this.course = course;
        setEvaluations(evaluations);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Геттер map оценок.
     * @return Map (String, Integer).
     */
    public Map<String, Integer> getEvaluations() {
        return evaluations;
    }

    public String getStringEvaluations() {
        String str = "";
        for (String k : evaluations.keySet()){
            str += k+" - " + evaluations.get(k) + ",";
        }
        return str;
    }

    /**
     * Вставка оценок.
     * @param evaluations мап с предметами и оценками.
     * @return 0, если все оценки в рамках пятибальной системы и изменения вступят в силу. Иначе -1.
     */
    public Integer setEvaluations(Map<String,Integer> evaluations) {
        Map<String ,Integer> temp = new HashMap<>();
        for(String it : evaluations.keySet()){
            int val = evaluations.get(it);
            if (val < 2 || val > 5){ // если несоблюдается условие пятибальной системы, то кидаем -1
                return -1;
            }
            temp.put(it,evaluations.get(it)); // заполняем временный map
        }
        this.evaluations = temp;
        return 0;
    }

    /**
     * Вставка оценок.
     * В случае, если в массив оценок меньше массива предметов, то недостающие оценки заполнятся случайно
     * от 2 до 5 включительно.
     * @param subjects предметы.
     * @param estimations оценки.
     * @return 0, если метод отработал стабильно. -1 если массив предметов пуст.
     */
    public Integer setEvaluations(String[] subjects, int[] estimations) {
        if(subjects.length == 0){
            return -1;
        }

        Map<String ,Integer> temp = new HashMap<>();
        int it = 0;
        try {
            do{
                temp.put(subjects[it], estimations[it]);
                it++;
            }while(it < subjects.length);
        }
        catch (IndexOutOfBoundsException e){
            do{
                temp.put(subjects[it], RandomGenerator.getDefault().nextInt(2,6));
                it++;
            }while(it < subjects.length);
        }
        this.evaluations = temp;
        return 0;

    }
    /**
     * Вставка оценок.
     * В случае, если в массив оценок меньше массива предметов, то недостающие оценки заполнятся 2-ми
     * @param subjects предметы.
     * @param estimations оценки.
     * @return 0, если метод отработал стабильно. -1 если массив предметов пуст.
     */
    public Integer setEvaluationsNoRand(String[] subjects, int[] estimations) {
        if(subjects.length == 0){
            return -1;
        }

        Map<String ,Integer> temp = new HashMap<>();
        int it = 0;
        try {
            do{
                temp.put(subjects[it], estimations[it]);
                it++;
            }while(it < subjects.length);
        }
        catch (IndexOutOfBoundsException e){
            do{
                temp.put(subjects[it], 2);
                it++;
            }while(it < subjects.length);
        }
        this.evaluations = temp;
        return 0;

    }

    /**
     * Вставка случайных оценок.
     * @param subjects предметы.
     * @return 0, если метод отработал стабильно. -1 если массив предметов пуст.
     */
    public Integer setEvaluations(String[] subjects) {
        if(subjects.length == 0){
            return -1;
        }

        Map<String ,Integer> temp = new HashMap<>();
        int it = 0;
        do{
            temp.put(subjects[it], RandomGenerator.getDefault().nextInt(2,6));
            it++;
        }while(it < subjects.length);
        this.evaluations = temp;
        return 0;
    }
    /**
     * Геттер оценки.
     * @param K название предмета.
     * @return оценка по предмету.
     */
    public Integer getEvaluation(String K) {
        return evaluations.get(K);
    }

    /**
     * Установка оценки.
     * @param K предмет.
     * @param V оценка.
     * @return Вернет предыдущее значение при изменении значения объекта, если это новый объект, вернется null.
     * Но если введеная оценка <2, то вернется -1.
     */
    public Integer setEvaluation(String K,Integer V) {
        if(V > 2 && V < 5){
            return evaluations.put(K,V);
        }
        else {
            return -1;
        }
    }

    /**
     * Геттер курса.
     * @return номер курса.
     */
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

}
