package inflearn.chap08;
import java.io.*;
import java.util.*;

public class chap8_2 {
    static int[] arr, select;
    static int N, M, count, max, min, sum;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        select = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void Solution() {
        DFS(0, 0);
    }

    public void DFS(int index, int value) {
        if (value > N) return;
        if (index==M) {
            max = Math.max(max, value);
            return;
        }
        DFS(index + 1, value + arr[index]);
        DFS(index + 1, value);
    }

    public static void main(String[] args) throws Exception {
        chap8_2 main = new chap8_2();
        main.input();
        main.Solution();
        System.out.println(max);
    }
}


