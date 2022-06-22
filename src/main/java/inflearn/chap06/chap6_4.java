package inflearn.chap06;

import java.io.*;
import java.util.*;

public class chap6_4 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        select = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            select[i] = Integer.parseInt(st.nextToken());
        }

    }

    public void Solution() {
        for (int i = 0; i < M; i++) {
            int index = find(select[i]);
            if(index<0) {
                cacheMiss();
            } else {
                cacheHit(index);
            }
            arr[0]=select[i];
            System.out.println(Arrays.toString(arr));
        }
    }
    public int find(int value) {
        int index = -1;
        for(int i=0;i<N;i++) {
            if(arr[i]==value) {
                return i;
            }
        }
        return index;
    }
    public void cacheMiss() {
        for(int i=N-1;i>0;i--) {
            arr[i]=arr[i-1];
        }
    }
    public void cacheHit(int index) {
        for(int i=index;i>0;i--) {
            arr[i]=arr[i-1];
        }
    }


    public static void main(String[] args) throws Exception {
        chap6_4 main = new chap6_4();
        main.input();
        main.Solution();
        System.out.println(Arrays.toString(arr));
    }
}

