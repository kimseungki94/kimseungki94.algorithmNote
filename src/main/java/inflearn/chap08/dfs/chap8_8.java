package inflearn.chap08.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_8 {
    static int N, M, count, R;
    static int[] arr, data, check;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static boolean isSelected;

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        arr = new int[N];
        data = new int[N];
        check = new int[N + 1];

    }

    public int DFS(int n, int r) {
        if (map[n][r] > 0) return map[n][r];
        if (n == r || r == 0) return map[n][r] = 1;
        return map[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }

    public void DFS2(int count, int sum) {
        if(isSelected) return;
        if (count == N) {
            if(sum==M) {
                for(int X : data) sb.append(X+" ");
                sb.append("\n");
                isSelected=true;
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                data[count] = i;
                DFS2(count + 1,sum+(data[count]*arr[count]));
                check[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_8 main = new chap8_8();
        main.input();
        for (int i = 0; i < N; i++) {
            arr[i] = main.DFS(N-1, i);
        }
        main.DFS2(0,0);
        System.out.println(sb.toString());
    }
}
