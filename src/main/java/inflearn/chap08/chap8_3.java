package inflearn.chap08;
import java.io.*;
import java.util.*;

public class chap8_3 {
    static int[] arr, select, time;
    static int N, M, count, max, min, sum;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        select = new int[N];
        time = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void Solution() {
        DFS(0, 0,0);
    }

    public void DFS(int index, int value, int limit) {
        if (limit > M) return;
        if (index==N) {
            max = Math.max(max, value);
            return;
        }
        DFS(index + 1, value + arr[index],limit+time[index]);
        DFS(index + 1, value, limit);
    }

    public static void main(String[] args) throws Exception {
        chap8_3 main = new chap8_3();
        main.input();
        main.Solution();
        System.out.println(max);
    }
}


