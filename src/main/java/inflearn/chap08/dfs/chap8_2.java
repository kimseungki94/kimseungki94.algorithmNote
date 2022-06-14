package inflearn.chap08.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class chap8_2 {
    static int N, M, max;
    static String answer;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] arr, check;

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        max = 0;
    }

    public void DFS(int index, int sum) {
        if (sum > N) return;
        if (index == M) {
            max = Math.max(max, sum);
            return;
        }
        DFS(index + 1, sum + arr[index]);
        DFS(index + 1, sum);

    }

    public static void main(String[] args) throws Exception {
        chap8_2 main = new chap8_2();
        main.input();
        main.DFS(0, 0);
        System.out.println(max);
    }
}
