package inflearn.chap10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap10_2 {

    static int N, M, count, max, len, min;
    static int[][] map, dis;
    static int[] arr, dp;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        dp = new int[N];
    }

    private void Solution() {
        DP();
    }

    private void DP() {
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<N;i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[N-1]);
    }

    public static void main(String[] args) throws Exception {
        chap10_2 main = new chap10_2();
        main.input();
        main.Solution();
    }
}
