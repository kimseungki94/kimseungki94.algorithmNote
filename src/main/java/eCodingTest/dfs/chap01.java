package eCodingTest.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap01 {

    static int N, count;
    static StringBuilder sb = new StringBuilder();
    static Deque<Character>  deque = new LinkedList<>();
    static int[][] map;
    static int[] dy= new int[]{-1,1,0,0};
    static int[] dx= new int[]{0,0,-1,1};
    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[5][6];
        for(int i=1;i<=4;i++) {
            st = new StringTokenizer(br.readLine());
            String[] text = st.nextToken().split("");
            for(int j=1;j<=5;j++) {
                int value = Integer.parseInt(text[j-1]);
                map[i][j]=value;
            }
        }
    }
    public void DFS(int row,int col) {
        if(map[row][col]==1) return;
        for(int i=0;i<4;i++) {
            map[row][col]=1;
            int y = row + dy[i];
            int x = col + dx[i];
            if(y>=1 && y<=4 && x>=1 && x<=5 && map[y][x]==0) {
                DFS(y,x);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap01 main = new chap01();
        main.input();
        for(int i=1;i<=4;i++) {
            for(int j=1;j<=5;j++) {
                if(map[i][j]==0) {
                    count++;
                    main.DFS(i,j);
                }
            }
        }
        System.out.println(count);
    }
}

