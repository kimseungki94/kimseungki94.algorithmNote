package inflearn.chap03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap3_5 {
    static int N, M, count, max;
    static int[] arr, data;
    static int[][] map;
    static int[] arr1, arr2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int sum = 1;
        for (int i = 2; i <= N; i++) {
            sum += i;
            if (N < sum) break;
            if ((N - sum) % i == 0) count++;
        }
        System.out.println(count);
    }
}
