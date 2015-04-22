import java.util.Scanner;

public class Island {
    int m,n;            // размер поля
    Node[][] map;       // поле
    public Island(int row, int column){
        n = row;
        m = column;
        map = new Node[n][m];
        for (int i = 0; i < n; i++) {               // создаем поле(инициализация)
            for (int j = 0; j < m; j++) {
                map[i][j] = new Node(i,j);
            }
        }
    }
    public void time(){
        for(int i =0; i<n;i++){     // для каждой строки
            for(int j = 0; j<m;j++){ // для каждой клетки
                if (map[i][j].rabbitArrayList != null && map[i][j].rabbitArrayList.size() > 0) { // если есть кролики
                    for (int k = map[i][j].rabbitArrayList.size() - 1; k >= 0; k--) { // для каждого кролика(перебор с конца!)
                        {
                            Rabbit temp = map[i][j].rabbitArrayList.get(k); // пересохранили кролика
                            if (!map[i][j].delete()) break; // если кролики, которые еще не сделали прыжок, удалили из массива кроликов
                            System.out.println(temp.x + " " + temp.y);// вывели координаты откуда
                            temp.jump();// осуществили прыжок
                            System.out.println(temp.x + " " + temp.y);// координаты куда прыгнул кролик
                            map[temp.x][temp.y].add(temp); // поместили кролика в ту клетку, куда он прыгнул
                        }
                    }
                }
            }

        }
        // прыжки всех кроликов завершены, подготовили кроликов к следующему прыжку
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < map[i][j].rabbitArrayList.size(); k++) {
                    if (map[i][j].rabbitArrayList!=null && map[i][j].rabbitArrayList.get(k) != null)
                    map[i][j].rabbitArrayList.get(k).is_ready_to_jump = true;
                }
            }
        }
    }
    @Override
    public String toString() { // вывод массива. Переопределили метод toString класса Object
        String s="";
        for(int i =0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(map[i][j].rabbitArrayList != null && map[i][j].rabbitArrayList.size() > 0)
                    // если есть кролики и их количество больше нуля
                    s+=" " + map[i][j].sum+ " "; //тогда выводим кол-во кроликов
                else s+= " 0 "; // иначе 0
            }
            s+="\n";
        }
        return s;
    }
    public static void main(String[] args) {
// TODO Auto-generated method stub
        // тестирование  программы
        int n = 3;
        int m = 3;
        Island a = new Island(n, m);        // создание ОДНОГО поля

        int[][] island = new int[][]{       // тестовый остров
                {1,0,0},
                {0,1,0},
                {0,0,1},
        };
        for(int i = 0; i < n; i++){           // заполнение острова
            for(int j = 0; j< m;j++){
                int t = island[i][j];
                // т.к. массив создан в конструкторе, то здесь достаточно добавить в массив кроликов каждого кролика
                if (t == 0){                // 0 - пусто
                }
                if(t==1){ // 1 - кролик
                    a.map[i][j].add(new Rabbit(i,j,n,m));
                }
            }
        }

        System.out.println(a.toString()); // изначальное положение
        for(int i =0; i < 200; i++){        // 200 прыжков
            a.time();
        }
        System.out.println(a.toString());   // положение после прыжков
    }

}