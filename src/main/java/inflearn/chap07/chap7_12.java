package inflearn.chap07;

import java.io.*;
import java.util.*;

public class chap7_12 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max,min;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        select = new int[N+1];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end]=1;
        }
        select[1]=1;
    }

    public void Solution() {
        DFS(1);
    }

    public void DFS(int start) {
        if(start==N) {
            count++;
        }
        for(int i=1;i<=N;i++) {
            if(map[start][i]==1 && select[i]==0) {
                select[i]=1;
                DFS(i);
                select[i]=0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap7_12 main = new chap7_12();
        main.input();
        main.Solution();
        System.out.println(count);
    }
}



