package inflearn.chap08.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_4 {
    static int N, M, max;
    static String answer;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] arr, check;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];
    }

    public void DFS(int index) {
        if (index == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(arr[i] + " ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            arr[index] = i;
            DFS(index + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_4 main = new chap8_4();
        main.input();
        main.DFS(1);
        System.out.println(sb.toString());
    }
}