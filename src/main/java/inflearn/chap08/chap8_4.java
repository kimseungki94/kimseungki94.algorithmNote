package inflearn.chap08;

import java.io.*;
import java.util.*;

public class chap8_4 {
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
    }

    public void Solution() {
        DFS(0);
    }

    public void DFS(int limit) {
        if (limit==M) {
            for(int n : arr) System.out.print(n+" ");
            System.out.println();
            return;
        }
        for(int i=1;i<=N;i++) {
            arr[limit]=i;
            DFS(limit+1);
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_4 main = new chap8_4();
        main.input();
        main.Solution();
        System.out.println(max);
    }
}


