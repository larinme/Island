public class Rabbit {
    int x,y,m,n;
    boolean is_ready_to_jump = true; // переменная, которая говорит, может ли этот кролик прыгать или нет
    public Rabbit(int x, int y, int n, int m){
        this.x=x;
        this.y=y;
        this.m=m;
        this.n = n;
    }
    public void jump() {
        if (is_ready_to_jump) { // если он прыжок ЕЩЕ не совершил
            int k = (int) (Math.random() * 9 - 1); //
            int dx = 0;
            int dy = 0;
            switch (k) {
                case 1:
                    dx = -1;
                    dy = -1;
                    break;
                case 2:
                    dx = 0;
                    dy = -1;
                    break;
                case 3:
                    dx = 1;
                    dy = -1;
                    break;
                case 4:
                    dx = -1;
                    dy = 0;
                    break;
                case 5:
                    dx = 0;
                    dy = 0;
                    break;
                case 6:
                    dx = 1;
                    dy = 0;
                    break;
                case 7:
                    dx = -1;
                    dy = 1;
                    break;
                case 8:
                    dx = 0;
                    dy = 1;
                    break;
                case 9:
                    dx = 1;
                    dy = 1;
                    break;
            }
            if ((x + dx < 0) && (dx == -1)) dx = 0;
            if ((x + dx > (n - 1)) && (dx == 1)) dx = 0;
            if ((y + dy < 0) && (dy == -1)) dy = 0;
            if ((y + dy > (m - 1)) && (dy == 1)) dy = 0;

            x += dx;
            y += dy;
        }
        is_ready_to_jump = false; // прыжок сделан, за этот шаг больше прыгать нельзя!
    }
}