package inflearn.chap08;

import java.io.*;
import java.util.*;

public class chap8_10 {
    static int[] arr, select;
    static int[][] map;
    static int[] dy= new int[]{-1,1,0,0};
    static int[] dx= new int[]{0,0,-1,1};
    static int N, M, count, max, min, sum;
    static int a, b;
    static boolean flag;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[8][8];
        for(int i=1;i<=7;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=7;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
    }

    public void Solution() {
        map[1][1]=1;
        DFS(1,1);
    }

    public void DFS(int row, int col) {
        if(row==7 && col==7) {
            count++;
            return;
        }
        for(int i=0;i<4;i++) {
            int y = row+dy[i];
            int x = col+dx[i];
            if(y>0 && y<=7 && x>0 && x<=7 && map[y][x]==0) {
                map[y][x]=1;
                DFS(y,x);
                map[y][x]=0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_10 main = new chap8_10();
        main.input();
        main.Solution();
        System.out.println(count);
    }
}


