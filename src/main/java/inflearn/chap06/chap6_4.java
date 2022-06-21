package inflearn.chap06;
import java.io.*;
import java.util.*;

public class chap6_4 {
    static int N, M, count, max, min;
    static int[] arr, memory;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memory = new int[N];
        st = new StringTokenizer(br.readLine());
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void func() {
        for (int i = 0; i < M; i++) {
            insert(arr[i]);
            System.out.println(Arrays.toString(memory));
        }
        for (int i = 0; i < N; i++) sb.append(memory[i] + " ");
    }

    public static void insert(int data) {
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (memory[i] == data) {
                index = i;
            }
        }
        if (index<0) {
            for (int i = index; i > 0; i--) {
                memory[i] = memory[i - 1];
            }
        } else {
            for (int i = N - 1; i > 0; i--) {
                memory[i] = memory[i-1];
            }
        }
        memory[0]=data;
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
        System.out.println(sb.toString());
    }
}

