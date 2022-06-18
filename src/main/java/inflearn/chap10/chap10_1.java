package inflearn.chap10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap10_1 {
    static int N, M, sum, count;
    static int[] arr, dy;
    static StringBuilder sb = new StringBuilder();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dy = new int[N+1];
    }


    public int DFS(int stair) {
        dy[1]=1;
        dy[2]=2;
        for(int i=3;i<=stair;i++) {
            dy[i]=dy[i-1]+dy[i-2];
        }
        return dy[stair];
    }

    public static void main(String[] args) throws Exception {
        chap10_1 main = new chap10_1();
        main.input();
        System.out.println(main.DFS(N));
    }

}


