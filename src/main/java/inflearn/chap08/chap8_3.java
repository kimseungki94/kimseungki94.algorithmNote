package inflearn.chap08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class chap8_3 {
    static int N, M, max;
    static String answer;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] arr, check;

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M];
        check = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            check[i] = Integer.parseInt(st.nextToken());
        }
        max = 0;
    }

    public void DFS(int index, int sum, int time) {
        if (time > N) return;
        if (index == M) {
            max = Math.max(max, sum);
            return;
        }
        DFS(index + 1, sum + arr[index], time + check[index]);
        DFS(index + 1, sum, time);

    }

    public static void main(String[] args) throws Exception {
        chap8_3 main = new chap8_3();
        main.input();
        main.DFS(0, 0, 0);
        System.out.println(max);
    }
}
