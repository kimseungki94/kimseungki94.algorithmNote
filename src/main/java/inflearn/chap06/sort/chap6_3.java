package inflearn.chap06.sort;

import java.io.*;
import java.util.*;

public class chap6_3 {
    static int N, M, count, max, min;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void func() {
        int temp;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) sb.append(arr[i] + " ");
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
        System.out.println(sb.toString());
    }
}
