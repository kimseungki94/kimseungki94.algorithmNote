package inflearn.chap10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap10_6 {

    static int N, M, count, max, len, min;
    static int[][] map, dis;

    public class Test implements Comparable<Test> {
        int score;
        int time;

        public Test(int score, int time) {
            this.score = score;
            this.time = time;
        }


        @Override
        public int compareTo(Test o) {
            if (this.time == o.time) return this.score - o.score;
            else return this.time - o.time;
        }
    }

    static int[] arr, dp;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Test> list = new ArrayList<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list.add(new Test(score, time));
        }
        Collections.sort(list);
    }

    private void Solution() {
        DP();
    }

    private void DP() {
        dp[M] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = M; j >= list.get(i).time; j--) {
                dp[j] = Math.max(dp[j], dp[j-list.get(i).time]+list.get(i).score);
            }
            System.out.println(Arrays.toString(dp));
        }

    }

    public static void main(String[] args) throws Exception {
        chap10_6 main = new chap10_6();
        main.input();
        main.Solution();
    }
}
