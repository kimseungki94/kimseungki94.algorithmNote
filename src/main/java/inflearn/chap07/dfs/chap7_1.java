package inflearn.chap07.dfs;

import java.io.*;
import java.util.*;

public class chap7_1 {
    static int N, M, sum, max;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static char[] c;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public static void DFS(int value) {
        if (value / 2 == 0) {
            sb.append(value % 2);
            return;
        } else {
            DFS(value / 2);
            sb.append(value % 2);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        DFS(N);
        System.out.println(sb.toString());
    }
}
