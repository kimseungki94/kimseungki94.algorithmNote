import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static int[] arr, weight, value, dp;
    //static int[][] data, dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.println(dp[M]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        value = new int[N];
        dp = new int[M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            value[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,10001);
        dp[0]=0;
    }

    public static void Solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= M; j++) {
                if (value[i] <= j) {
                    dp[j]=Math.min(dp[j],dp[j-value[i]]+1);
                }
            }
        }
    }
}