package inflearn.chap08;
import java.io.*;
import java.util.*;

public class chap8_7 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max, min, sum;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        arr = new int[N];
        select = new int[M];
    }

    public void Solution() {
        System.out.println(DFS(N,M));
    }

    public int DFS(int lt,int rt) {
        if(map[lt][rt]>0) return map[lt][rt];
        if(lt==rt || rt==0) return map[lt][rt]=1;
        else return map[lt][rt]=DFS(lt-1,rt)+DFS(lt-1,rt-1);
    }

    public static void main(String[] args) throws Exception {
        chap8_7 main = new chap8_7();
        main.input();
        main.Solution();
    }
}


