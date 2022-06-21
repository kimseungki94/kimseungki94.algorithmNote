package inflearn.chap06;

import java.io.*;
import java.util.*;

public class chap6_9 {
    static int N, M, sum;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void func() {
        int lt, rt, mid, answer;
        lt = Arrays.stream(arr).max().getAsInt();
        rt = Arrays.stream(arr).sum();
        mid = answer = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (judge(mid) <= M) {
                answer=mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static int judge(int data) {
        int size = 1;
        sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + arr[i] > data) {
                size++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return size;
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}

