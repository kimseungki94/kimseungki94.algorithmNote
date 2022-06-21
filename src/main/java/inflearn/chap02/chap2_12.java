package inflearn.chap02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chap2_12 {
    static int N, M, count, max;
    static int[] arr, data;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=N; j++) {
                int rank = Integer.parseInt(st.nextToken());
                map[i][rank]=j;
            }
        }
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                boolean isSelected = true;
                for(int k=0;k<M;k++) {
                    if(i==j ||map[k][i]>map[k][j]) {
                        isSelected=false;
                        break;
                    }
                }
                if(isSelected) count++;
            }
        }
        System.out.println(count);
    }
}
