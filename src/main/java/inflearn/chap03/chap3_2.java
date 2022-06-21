package inflearn.chap03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class chap3_2 {
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
        int lt, rt;
        lt = rt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }
        st = new StringTokenizer(br.readLine());
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr2[i] = value;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while (lt != N && rt != M) {
            if (arr1[lt] < arr2[rt]) lt++;
            else if (arr1[lt] > arr2[rt]) rt++;
            else {
                sb.append(arr1[lt] + " ");
                lt++;
                rt++;
            }
        }
        System.out.println(sb.toString());
    }
}

