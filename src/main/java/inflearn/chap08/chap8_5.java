package inflearn.chap08;
import java.io.*;
import java.util.*;

public class chap8_5 {
    static int[] arr, select;
    static int N, M, count, max, min, sum;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
    }

    public void Solution() {
        DFS(0, 0);
    }

    public void DFS(int count, int limit) {
        if (limit > M) return;
        if (limit == M) {
            min = Math.min(min, count);
        }
        for (int i = 0; i < N; i++) {
            DFS(count + 1, limit + arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_5 main = new chap8_5();
        main.input();
        main.Solution();
        System.out.println(min);
    }
}



