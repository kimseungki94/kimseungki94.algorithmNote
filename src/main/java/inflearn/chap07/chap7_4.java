package inflearn.chap07;


import java.io.*;
import java.util.*;

public class chap7_4 {
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
        DFS(N);
        for(int i=1;i<=N;i++) sb.append(arr[i]+" ");
    }

    public int DFS(int value) {
        if (arr[value] > 0) return arr[value];
        if (value == 1 || value == 2) {
            return arr[value] = 1;
        } else {
            return arr[value] = DFS(value - 1) + DFS(value - 2);
        }
    }

    public static void main(String[] args) throws Exception {
        chap7_4 main = new chap7_4();
        main.input();
        main.Solution();
        System.out.println(sb.toString());
    }
}


