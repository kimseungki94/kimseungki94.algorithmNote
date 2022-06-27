package inflearn.chap10;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap10_3 {

    static int N, M;
    static int[] arr,dp;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,1);
        for(int i=1;i<N-1;i++) {
            for(int j=i-1;j>=0;j--) {
                if(arr[i]>arr[j]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
    }
    public static void main(String[] args) throws Exception {
        chap10_3 main = new chap10_3();
        main.input();
    }
}
