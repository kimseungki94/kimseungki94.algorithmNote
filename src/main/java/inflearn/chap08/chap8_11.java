package inflearn.chap08;
import java.io.*;
import java.util.*;

public class chap8_11 {
    static int[] arr, select;
    static int[][] map, visit;
    static int[] dy= new int[]{-1,1,0,0};
    static int[] dx= new int[]{0,0,-1,1};
    static int N, M, count, max, min, sum;
    static int a, b;
    static boolean flag;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static Queue<Node> queue = new LinkedList<>();

    public class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[8][8];
        visit = new int[8][8];
        for(int i=1;i<=7;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=7;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
    }

    public void Solution() {
        map[1][1]=1;
        System.out.println(BFS());
    }

    private int BFS() {
        queue.offer(new Node(1,1));
        while (!queue.isEmpty()) {
            count++;
            int len = queue.size();
            for(int i=0;i<len;i++) {
                Node node = queue.poll();
                for(int j=0;j<4;j++) {
                    int row = node.row+dy[j];
                    int col = node.col+dx[j];
                    if(row>0 && row<=7 && col>0 && col<=7 && map[row][col]==0 && visit[row][col]==0) {
                        if(row==7 && col==7) return count;
                        visit[row][col]=1;
                        queue.offer(new Node(row,col));
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        chap8_11 main = new chap8_11();
        main.input();
        main.Solution();
    }
}


