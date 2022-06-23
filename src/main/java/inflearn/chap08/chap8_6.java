package inflearn.chap08;
import java.io.*;
import java.util.*;

public class chap8_6 {
    static int[] arr, select;
    static int N, M, count, max, min, sum;
    static int a, b;
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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void Solution() {
        DFS(0);
    }

    public void DFS(int count) {
        if (count == M) {
            for(int i : select) System.out.print(i+" ");
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if(count>0 && arr[i]==select[count-1]) continue;
            select[count]=arr[i];
            DFS(count+1);
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_6 main = new chap8_6();
        main.input();
        main.Solution();
    }
}


