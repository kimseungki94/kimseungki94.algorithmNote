package inflearn.chap07;


import java.io.*;
import java.util.*;

public class chap7_6 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public void Solution() {
        arr = new int[N + 1];
        DFS(1);
    }

    public void DFS(int index) {
        if (index > N) {
            for (int i = 1; i <= N; i++) if (arr[i] == 1) System.out.print(i + " ");
            System.out.println();
            return;
        } else {
            arr[index] = 1;
            DFS(index + 1);
            arr[index] = 0;
            DFS(index + 1);
        }

    }

    public static void main(String[] args) throws Exception {
        chap7_6 main = new chap7_6();
        main.input();
        main.Solution();
    }
}

