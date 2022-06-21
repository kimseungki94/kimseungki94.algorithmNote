package inflearn.chap08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_13 {

    static int N, M, count;
    static int[][] map, dis, isVisited;
    static int[] dy = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dx = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dis = new int[N][N];
        isVisited = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) dis[i][j] = 1;
            }
        }
    }

    public void start(int row, int col) {
        if (map[row][col] == 1) {
            count++;
            DFS(row, col);
        }
    }

    public void DFS(int row, int col) {
        map[row][col] = 0;
        for (int k = 0; k < 8; k++) {
            int y = row + dy[k];
            int x = col + dx[k];
            if (x >= 0 && x < N && y >= 0 && y < N && map[y][x] == 1) {
                DFS(y, x);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_13 main = new chap8_13();
        main.input();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                main.start(i, j);
            }
        }
        System.out.println(count);
    }
}