package inflearn.chap08.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_6 {
    static int N, M, count;
    static int[] arr, data, check;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N];
        check = new int[N];
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void DFS(int index) {
        if (index == M) {
            for (int X : arr) sb.append(X + " ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(check[i]==0) {
                arr[index] = data[i];
                check[i]=1;
                DFS(index + 1);
                check[i]=0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_6 main = new chap8_6();
        main.input();
        main.DFS(0);
        System.out.println(sb.toString());
    }
}