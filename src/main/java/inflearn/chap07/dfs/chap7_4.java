package inflearn.chap07.dfs;
import java.io.*;
import java.util.*;

public class chap7_4 {
    static int N, M, sum, max;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
    }

    public static int DFS(int limit) {
        if (arr[limit] > 0) {
            return arr[limit];
        }
        if (limit < 3) {
            return arr[limit] = 1;
        } else {
            return arr[limit] = DFS(limit - 2) + DFS(limit - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(DFS(N));
        for (int i = 1; i <= N; i++) System.out.println(arr[i]);
    }
}

