import java.util.Scanner;

public class Island {
    int m,n;
    Node[][] map;
    public Island(int row, int column){
        n = row;
        m = column;
        map = new Node[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = new Node(i,j);
            }
        }
    }
    public void time(){
        for(int i =0; i<n;i++){
            for(int j = 0; j<m;j++){
                if (map[i][j].rabbitArrayList != null && map[i][j].rabbitArrayList.size() > 0) {
                    for (int k = map[i][j].rabbitArrayList.size() - 1; k >= 0; k--) {
                        {
                            Rabbit temp = map[i][j].rabbitArrayList.get(k);
                            map[i][j].delete();
                            System.out.println(temp.x + " " + temp.y);
                            temp.jump();
                            System.out.println(temp.x + " " + temp.y);
                            map[temp.x][temp.y].add(temp);
                        }
                    }
                }
            }

        }
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
    public String toString() {
        String s="";
        for(int i =0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(map[i][j].rabbitArrayList != null && map[i][j].rabbitArrayList.size() > 0) s+=" " + map[i][j].sum+ " ";
                else s+= " 0 ";
            }
            s+="\n";
        }
        return s;
    }
    public static void main(String[] args) {
// TODO Auto-generated method stub
        int n = 3;
        int m = 3;
        Island a = new Island(n, m);
        Scanner in = new Scanner(System.in);
        int[][] island = new int[][]{
                {1,0,1},
                {0,1,0},
                {1,0,0},
        };
        for(int i = 0; i < n; i++){
            for(int j = 0; j< m;j++){
                int t = island[i][j];
                if (t == 0){
                    a.map[i][j] = new Node(i,j);
                }
                if(t==1){
                    a.map[i][j] = new Node(i,j);
                    a.map[i][j].add(new Rabbit(i,j,n,m));
                }
            }
        }

        System.out.println(a.toString());
        for(int i =0; i < 3; i++){
            a.time();
            System.out.println(a.toString());
        }

    }

}