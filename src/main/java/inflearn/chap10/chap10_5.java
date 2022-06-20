package inflearn.chap10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap10_5 {
    static int N, M, sum, count, max;
    static int[] arr, dy, coin;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        coin = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        dy = new int[M + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
    }


    public int DP() {
        for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j <= M; j++) {
                dy[j] = Math.min(dy[j - coin[i]] + 1, dy[j]);
            }
        }
        System.out.println(Arrays.toString(dy));
        return dy[M];
    }

    public static void main(String[] args) throws Exception {
        chap10_5 main = new chap10_5();
        main.input();
        System.out.println(main.DP());
    }

}


