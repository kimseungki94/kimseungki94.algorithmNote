package inflearn.chap08;
import java.io.*;
import java.util.*;

public class chap8_9 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max, min, sum;
    static int a, b;
    static boolean flag;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
    }

    public void Solution() {
        DFS(1,0);
    }

    public void DFS(int index, int count) {
        if(count==M) {
            for(int n : arr) System.out.print(n+" ");
            System.out.println();
            return;
        }
        for(int i=index;i<=N;i++) {
            arr[count]=i;
            DFS(i+1, count+1);
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_9 main = new chap8_9();
        main.input();
        main.Solution();
    }
}


