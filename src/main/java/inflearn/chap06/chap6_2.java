package inflearn.chap06;

import java.io.*;
import java.util.*;

public class chap6_2 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }

    public void Solution() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        chap6_2 main = new chap6_2();
        main.input();
        main.Solution();
        System.out.println(Arrays.toString(arr));
    }
}

