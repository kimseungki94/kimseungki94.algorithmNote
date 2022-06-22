package inflearn.chap06;


import java.io.*;
import java.util.*;

public class chap6_9 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    public void input() throws Exception {
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

    public int Solution() {
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int mid = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            int size = count(mid);
            if (size > M) {
                lt = mid + 1;
            } else if (size <= M) {
                rt = mid - 1;
            }
        }
        return mid+1;
    }

    public int count(int m) {
        int sum = 0;
        int size = 1;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > m) {
                sum = arr[i];
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) throws Exception {
        chap6_9 main = new chap6_9();
        main.input();
        System.out.println(main.Solution());
    }
}

