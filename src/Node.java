import java.util.ArrayList;

/**
 * Created by Евгений on 18.04.2015.
 */
public class Node {
    int x,y;
    int sum = 0;
    ArrayList<Rabbit> rabbitArrayList = new ArrayList<>();
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
    public boolean delete(){ // метод возвращает true, если удалить удалось
            int i = rabbitArrayList.size() - 1; // номер последнего кролика
            if (i < 0) return false; // если кроликов нет, выйти
        while (!rabbitArrayList.get(i).is_ready_to_jump) { // если последний кролик прыгал, то выбираем на 1 позицию меньше
            i--;
            if (i < 0) return false; // если дошли до конца, а все кролики прыгнули уже, выйти из метода
        }
            rabbitArrayList.remove(i); // если нашли кролика, готового прыгнуть, то удалить его
            rabbitArrayList.trimToSize(); // подогнать по размеру
            sum--; // количество кроликов уменьшить на 1
        return true; // найти кролика, готового прыгнуть, удалось
    }
    public void add(Rabbit temp){
        rabbitArrayList.add(temp); // добавить кролика
        rabbitArrayList.trimToSize(); // подогнать по размеру
        sum++; // счетчик кроликов + 1
    }
}
