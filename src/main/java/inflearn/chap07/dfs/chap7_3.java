package inflearn.chap07.dfs;

import java.io.*;
import java.util.*;

public class chap7_3 {
    static int N, M, sum, max;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static char[] c;
    static long answer;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public static long DFS(long value) {
        if (value == 0) {
            return 1;
        } else {
            return value*DFS(value-1);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(DFS(N));
    }
}
