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
    }

    public static void Solution() {

    }

    private static void findValue(int index) {
    }
}