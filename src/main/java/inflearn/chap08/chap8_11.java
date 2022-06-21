package inflearn.chap08;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_11 {
    public class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int count;
    static int[][] map;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    static Queue<Point> queue = new LinkedList<>();
    static boolean flag =true;

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[7][7];
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        map[0][0]=1;
        count = 1;
    }

    public int BFS(int row, int col) {
        queue.offer(new Point(row, col));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point position = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int y = position.row + dy[j];
                    int x = position.col + dx[j];
                    if (y == 6 && x == 6) {
                        flag = false;
                        return count;
                    }
                    if (x >= 0 && x < 7 && y >= 0 && y < 7 && map[y][x] == 0) {
                        map[y][x]=1;
                        queue.offer(new Point(y, x));
                    }
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        chap8_11 main = new chap8_11();
        main.input();
        main.BFS(0, 0);
        if(flag) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
