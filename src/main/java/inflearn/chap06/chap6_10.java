package inflearn.chap06;

import java.io.*;
import java.util.*;

public class chap6_10 {
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
        select = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    public int Solution() {
        int lt = Arrays.stream(arr).min().getAsInt();
        int rt = Arrays.stream(arr).max().getAsInt();
        int mid = 0;
        int temp=0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            int size = count(mid);
            if (size >= M) {
                temp=mid;
                lt = mid + 1;
            } else if (size < M) {
                rt = mid - 1;
            }
        }
        return temp;
    }

    public int count(int m) {
        int lt=0;
        int horse=1;
        for(int rt = 0;rt<N;rt++) {
            if(arr[rt]-arr[lt]>=m) {
                lt=rt;
                horse++;
            }
        }
        return horse;
    }

    public static void main(String[] args) throws Exception {
        chap6_10 main = new chap6_10();
        main.input();
        System.out.println(main.Solution());
    }
}

