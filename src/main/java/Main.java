import java.io.*;
import java.util.*;

public class Main {
<<<<<<< HEAD
    static int N, M;
    static int[] arr, dp;
=======
    static long N, M, T, count;
>>>>>>> f326303d2265e118110730e9f314714d9cb49178
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Solution();
<<<<<<< HEAD
=======
        System.out.println(count);
>>>>>>> f326303d2265e118110730e9f314714d9cb49178
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
<<<<<<< HEAD
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void Solution() {
        for (int i = 0; i < N; i++) {
            findValue(i);
        }
        int value=0;
        for(int a : dp) {
            value=Math.max(value,a);
        }
        System.out.println(value);
    }

    private static int findValue(int index) {
        if (dp[index] == 0) {
            dp[index] = 1;
            for (int i = index - 1; i >= 0; i--) {
                if (arr[index] > arr[i]) {
                    dp[index] = Math.max(dp[index], findValue(i) + 1);
                }
            }
        } else {
            return dp[index];
=======
        M = Integer.parseInt(st.nextToken());
    }

    public static void Solution() {
        long limit = 100 * M / N;

        if (limit >= 99) {
            count = -1;
        } else {

            long lt = 0;
            long rt = 2_000_000_000;

            while (lt < rt) {
                long mid = (lt + rt) / 2;

                long ret = 100 * (M + mid) / (N + mid);

                if (ret > limit) {
                    rt = mid;
                } else {
                    lt = mid + 1;
                }
            }
            count = rt;
>>>>>>> f326303d2265e118110730e9f314714d9cb49178
        }
        return 0;
    }
}