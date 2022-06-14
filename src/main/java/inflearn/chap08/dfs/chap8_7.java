package inflearn.chap08.dfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_7 {
    static int N, M, count;
    static int[] arr, data, check;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
    }

    public int DFS(int n, int m) {
        if (map[n][m] > 0) return map[n][m];
        if (m == 0 || n == m) return map[n][m] = 1;
        else return map[n][m] = DFS(n-1,m-1) + DFS(n-1,m);

    }

    public static void main(String[] args) throws Exception {
        chap8_7 main = new chap8_7();
        main.input();
        System.out.println(main.DFS(N, M));
    }
}