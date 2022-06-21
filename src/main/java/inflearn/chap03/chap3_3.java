package inflearn.chap03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class chap3_3 {
    static int N, M, count, max;
    static int[] arr, data;
    static int[][] map;
    static int[] arr1, arr2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int lt;
        lt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }
        int sum=0;
        for(int i=0;i<M-1;i++) {
            sum+=arr[i];
        }
        for(int rt=M-1;rt<N;rt++) {
            sum+=arr[rt];
            max = Math.max(max,sum);
            sum-=arr[lt++];
        }
        System.out.println(max);
    }
}

