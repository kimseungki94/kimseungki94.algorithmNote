package inflearn.chap02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap2_9 {
    static int N, count, max;
    static int[] arr, data;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int sum2=0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i==j) sum2+=map[i][j];
                sum += map[i][j];
            }
            max = Math.max(sum, max);
            max = Math.max(sum2, max);
        }
        for(int i=0;i<N;i++) {
            int sum=0;
            for(int j=0;j<N;j++) {
                sum+=map[j][i];
            }
            max = Math.max(max,sum);
        }
        int lt,rt;
        lt = 0;
        rt = N-1;
        sum2=0;
        for(int i=0;i<N;i++) {
            sum2+=map[lt++][rt--];
        }
        max = Math.max(max,sum2);

        System.out.println(max);
    }
}
