package inflearn.chap06.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chap6_6 {
    static int N, M, count, max, min;
    static int[] arr, memory;
    static String text = "U";
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(st.nextToken());
            arr[i] = data;
        }
        memory = arr.clone();
    }

    public static void func() {
        int a, b;
        a = b = -1;
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            if (arr[i] != memory[i]) {
                if (a > 0) {
                    b = i + 1;
                } else {
                    a = i + 1;
                }
            }
        }
        System.out.println(a + " " + b);
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}

