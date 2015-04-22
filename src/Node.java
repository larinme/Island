import java.util.ArrayList;

/**
 * Created by ������� on 18.04.2015.
 */
public class Node {
    int x,y;
    int sum = 0;
    ArrayList<Rabbit> rabbitArrayList = new ArrayList<>();
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
    public boolean delete(){ // ����� ���������� true, ���� ������� �������
            int i = rabbitArrayList.size() - 1; // ����� ���������� �������
            if (i < 0) return false; // ���� �������� ���, �����
        while (!rabbitArrayList.get(i).is_ready_to_jump) { // ���� ��������� ������ ������, �� �������� �� 1 ������� ������
            i--;
            if (i < 0) return false; // ���� ����� �� �����, � ��� ������� �������� ���, ����� �� ������
        }
            rabbitArrayList.remove(i); // ���� ����� �������, �������� ��������, �� ������� ���
            rabbitArrayList.trimToSize(); // ��������� �� �������
            sum--; // ���������� �������� ��������� �� 1
        return true; // ����� �������, �������� ��������, �������
    }
    public void add(Rabbit temp){
        rabbitArrayList.add(temp); // �������� �������
        rabbitArrayList.trimToSize(); // ��������� �� �������
        sum++; // ������� �������� + 1
    }
}
