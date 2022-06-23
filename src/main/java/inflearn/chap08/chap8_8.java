package inflearn.chap08;

import java.io.*;
import java.util.*;

public class chap8_8 {
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
        map = new int[N+1][N+1];
        arr = new int[N];
        select = new int[N+1];
    }

    public void Solution() {
        DFS(0);
    }

    public void DFS(int count) {
        if(flag) return;
        if(N==count) {
            int sum=0;
            for(int i=0;i<N;i++) {
                sum+=arr[i]*conbination(N-1,i);
            }
            if(sum==M) {
                flag=true;
                for(int n : arr) System.out.print(n+" ");
            }
            return;
        }
        for(int i=1;i<=N;i++) {
            if(select[i]==0) {
                arr[count]=i;
                select[i]=1;
                DFS(count+1);
                select[i]=0;
            }
        }
    }

    private int conbination(int lt, int rt) {
        if(map[lt][rt]>0) return map[lt][rt];
        if(lt==rt || rt==0) return 1;
        else return map[lt][rt] = conbination(lt-1,rt)+conbination(lt-1,rt-1);
    }

    public static void main(String[] args) throws Exception {
        chap8_8 main = new chap8_8();
        main.input();
        main.Solution();
    }
}


