package inflearn.chap08.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_10 {
    static int count;
    static int[][] map;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};

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
        map[0][0] = 1;
    }

    public void DFS(int row, int col) {
        if (row == 6 && col == 6) {
            count++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int y = row + dy[i];
            int x = col + dx[i];
            if (x >= 0 && x < 7 && y >= 0 && y < 7 && map[y][x] == 0) {
                map[y][x] = 1;
                DFS(y, x);
                map[y][x] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_10 main = new chap8_10();
        main.input();
        main.DFS(0, 0);
        System.out.println(count);
    }
}
