package inflearn.chap06.sort;

import java.io.*;
import java.util.*;

public class chap6_10 {
    static int N, M, sum, max;
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
        Arrays.sort(arr);
    }

    public static void func() {
        int lt, rt, mid, answer;
        lt = 1;
        rt = arr[N - 1];
        mid = answer = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (judge(mid) < M) {
                rt = mid - 1;
            } else {
                answer = mid;
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static int judge(int data) {
        int place = 1;
        int left = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i]-left >= data) {
                place++;
                left=arr[i];
            } else {
                continue;
            }
        }
        return place;
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
