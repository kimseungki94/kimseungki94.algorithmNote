package inflearn.chap06.sort;

import java.io.*;
import java.util.*;

public class chap6_5 {
    static int N, M, count, max, min;
    static int[] arr, memory;
    static String text="U";
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
        for (int i = 1; i < N; i++) {
            int index = arr[i];
            boolean isSelected = false;
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (index < arr[j]) {
                    arr[j + 1] = arr[j];
                } else if (index == arr[j]) {
                    isSelected=true;
                } else {
                    break;
                }
            }
            if(isSelected) {
                text="D";
                break;
            }
            arr[j + 1] = index;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
        System.out.println(text);
    }
}
