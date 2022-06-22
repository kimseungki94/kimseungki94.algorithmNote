package inflearn.chap06;

import java.io.*;
import java.util.*;

public class chap6_3 {
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
        for (int i = 1; i < N; i++) {
            int temp = arr[i];
            int j;
            for(j=i-1;j>=0;j--) {
                if(temp<arr[j]) {
                    arr[j+1]=arr[j];
                }
                else break;
            }
            arr[j+1]=temp;
        }
    }


    public static void main(String[] args) throws Exception {
        chap6_3 main = new chap6_3();
        main.input();
        main.Solution();
        System.out.println(Arrays.toString(arr));
    }
}

