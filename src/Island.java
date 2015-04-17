import java.util.Scanner;

public class Island {
    int m,n;
    Object[][] map;
    public Island(int row, int column){
        n = row;
        m = column;
        map = new Object[n][m];
    }
    public void time(){
        for(int i =0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(map[i][j] != null)
                {
                    Rabbit temp = (Rabbit)map[i][j];
                    System.out.println(temp.x + " " + temp.y);
                    temp.jump();
                    System.out.println(temp.x + " " + temp.y);
                    map[i][j] = temp;
                }
            }

        }
    }
    @Override
    public String toString() {
        String s="";
        for(int i =0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(map[i][j] == null) s+=" 0 ";
                else s+= " 1 ";
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
        for(int i = 0; i < n; i++){
            for(int j = 0; j< m;j++){
                int t = in.nextInt();
                if(t == 0){
                    a.map[i][j] = null;

                }
                if(t==1) a.map[i][j] = new Rabbit(i,j, n,m);
            }
        }

        System.out.println(a.toString());
        for(int i =0; i < 3; i++){
            a.time();
        }
        System.out.println(a.toString());
    }

}