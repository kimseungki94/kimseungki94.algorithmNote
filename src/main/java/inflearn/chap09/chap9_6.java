package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_6 {

    static int N, M, count, max, len, min;
    static int[][] map, dis;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public int find(int index) {
        if(arr[index]==index) return index;
        else {
            return arr[index]=find(arr[index]);
        }
    }

    public void union(int a,int b) {
        int findA = find(a);
        int findB = find(b);
        if(findA!=findB) {
            arr[findA]=b;
        };
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for(int i=1;i<=N;i++) {
            arr[i]=i;
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start<end){
                union(start, end);
            } else {
                union(end,start);
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        int end = find(Integer.parseInt(st.nextToken()));
        if(start!=end) System.out.println("NO");
        else System.out.println("YES");
    }

    private void Solution() {
    }

    public static void main(String[] args) throws Exception {
        chap9_6 main = new chap9_6();
        main.input();
        main.Solution();
    }
}
