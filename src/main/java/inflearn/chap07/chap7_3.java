package inflearn.chap07;

import java.io.*;
import java.util.*;

public class chap7_3 {
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
        System.out.println(DFS(N));
    }

    public int DFS(int value) {
        if (value == 0) {
            return 1;
        } else {
            return value * DFS(value - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        chap7_2 main = new chap7_2();
        main.input();
        main.Solution();
    }
}

