/**
 * Класс стол, способный хранить "на себе" любой объект.<br>
 *
 * @param <T> тип объекта над которым работаем(любой)
 */
public class Table<T> implements TableInterface<T> {
    private T item;

    Table(T item){
        this.item=item;
    }

    public T getItem() {
        return this.item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    /**
     * "Ворует" объект со стола, а оригинал, хранящийся на столе удаляется.
     * @return копию предмета
     */
    @Override
    public T stealItem(){
        T temp =  this.item;
        this.item = null;
        return temp;
    }


}
