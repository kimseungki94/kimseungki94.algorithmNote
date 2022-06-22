package inflearn.chap06;

import java.io.*;
import java.util.*;

public class chap6_6 {
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
        arr = new int[N];
        select = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i]=value;
            select[i]=value;
        }
        Arrays.sort(select);
    }

    public void Solution() {
        for(int i=0;i<N;i++) {
            if(arr[i]!=select[i]){
                sb.append(i+1+" ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap6_6 main = new chap6_6();
        main.input();
        main.Solution();
        System.out.println(sb.toString());
    }
}

