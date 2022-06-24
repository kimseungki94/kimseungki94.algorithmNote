import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, count, max, len, min;
    static int[][] map, dis;
    static int[] arr, dp;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        dp = new int[M+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
    }

    private void Solution() {
        DP();
    }

    private void DP() {
        dp[0]=0;
        for(int i=0;i<N;i++) {
            for(int j=arr[i];j<=M;j++) {
                dp[j]=Math.min(dp[j],dp[j-arr[i]]+1);
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[M]);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        main.Solution();
    }
}
