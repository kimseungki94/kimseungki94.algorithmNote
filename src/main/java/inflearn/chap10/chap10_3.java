package inflearn.chap10;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap10_3 {

    static int N, max;
    static int[][] map, dis;
    static int[] arr, dp;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            dp[i]=1;
        }
    }

    private void Solution() {
        DP();
    }

    private void DP() {
        for(int i=1;i<N;i++) {
            int find=1;
            for(int j=i-1;j>=0;j--) {
                if(arr[i]>arr[j]) find = Math.max(dp[j]+1,find);
            }
            dp[i]=find;
            max = Math.max(max,find);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        chap10_3 main = new chap10_3();
        main.input();
        main.Solution();
    }
}
