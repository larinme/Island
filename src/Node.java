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
    public void delete(){
        rabbitArrayList.remove(rabbitArrayList.size()-1);
        rabbitArrayList.trimToSize();
        sum--;
    }
    public void add(Rabbit temp){
        rabbitArrayList.add(temp);
        rabbitArrayList.trimToSize();
        sum++;
    }
}
