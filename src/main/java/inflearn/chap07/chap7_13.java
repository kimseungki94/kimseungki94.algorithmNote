package inflearn.chap07;

import java.io.*;
import java.util.*;

public class chap7_13 {
    static int[] arr, select;
    static int N, M, count, max,min;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        select = new int[N+1];
        for(int i=0;i<=N;i++) {
            map.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(start).add(end);
        }
        select[1]=1;
    }

    public void Solution() {
        DFS(1);
    }

    public void DFS(int start) {
        if(start==N) {
            System.out.println();
            count++;
        }
        for(int end : map.get(start)) {
            if(select[end]==0) {
                select[end]=1;
                DFS(end);
                select[end]=0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap7_13 main = new chap7_13();
        main.input();
        main.Solution();
        System.out.println(count);
    }
}


