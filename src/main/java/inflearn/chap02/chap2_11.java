package inflearn.chap02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chap2_11 {
    static int N, count, max;
    static int[] arr, data;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int room = Integer.parseInt(st.nextToken());
                map[i][j] = room;
            }
        }
        int index=1;
        for (int i = 0; i < N; i++) {
            int sum=0;
            for(int j=0;j<N;j++) {
                for(int k=1;k<=5;k++) {
                    if(i==j) continue;
                    if(map[i][k]==map[j][k]) {
                        sum++;
                        break;
                    }
                }
            }
            if(max<sum) {
                index=i+1;
                max=sum;
            }
        }
        System.out.println(index);
    }
}
