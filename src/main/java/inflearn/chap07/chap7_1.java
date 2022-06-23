package inflearn.chap07;

import java.io.*;
import java.util.*;

public class chap7_1 {
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
    }

    public void Solution() {
        DFS(N);
    }
    public void DFS(int value) {
        if(value==0){
            return;
        } else {
            DFS(value-1);
            System.out.print(value+" ");
        }
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
        chap7_1 main = new chap7_1();
        main.input();
        main.Solution();
    }
}


