import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, dp;


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

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

    private static void findValue(int index) {
        if (dp[index] == 0) {
            dp[index] = 1;
            for (int i = index - 1; i >= 0; i--) {
                if (arr[index] > arr[i]) {
                }
            }
        } else {
        }
    }
}