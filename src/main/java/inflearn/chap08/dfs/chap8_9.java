package inflearn.chap08.dfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_9 {
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
        arr = new int[M];
    }

    public void DFS(int count, int value) {
        if (count == M) {
            for (int x : arr) sb.append(x + " ");
            sb.append("\n");
            return;
        } else {
            for (int i = value + 1; i <= N; i++) {
                arr[count] = i;
                DFS(count + 1, i);
            }
        }

    }


    public static void main(String[] args) throws Exception {
        chap8_9 main = new chap8_9();
        main.input();
        main.DFS(0, 0);
        System.out.println(sb.toString());
    }
}
