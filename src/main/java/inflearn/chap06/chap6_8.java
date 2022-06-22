package inflearn.chap06;

import java.io.*;
import java.util.*;

public class chap6_8 {
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
        Arrays.sort(arr);
    }

    public int Solution() {
        int lt,rt,mid;
        lt=0;
        rt=N-1;
        while (lt<=rt){
            mid=(rt+lt)/2;
            if(arr[mid]==M) return mid+1;
            if(arr[mid]>M){
                rt=mid-1;
            } else {
                lt=mid+1;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        chap6_8 main = new chap6_8();
        main.input();
        System.out.println(main.Solution());
    }
}

