package inflearn.chap08.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_14 {

    public class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, count;
    static int[][] map;
    static int[] dy = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dx = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
    static Queue<Point> queue = new LinkedList<>();

    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public void BFS(int row, int col) {
        if (map[row][col] == 0) return;
        count++;
        queue.offer(new Point(row, col));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            map[point.row][point.col] = 0;
            for (int k = 0; k < 8; k++) {
                int y = point.row + dy[k];
                int x = point.col + dx[k];
                if (x >= 0 && x < N && y >= 0 && y < N && map[y][x] == 1) {
                    queue.offer(new Point(y, x));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_14 main = new chap8_14();
        main.input();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                main.BFS(i, j);
            }
        }
        System.out.println(count);
    }
}

