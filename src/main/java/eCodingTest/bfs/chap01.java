package eCodingTest.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chap01 {
    static int N,M,count;
    static int[] dy= new int[]{-1,1,0,0};
    static int[] dx= new int[]{0,0,-1,1};
    static int[][] map;
    static Queue<Point> queue = new LinkedList<>();
    
    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            for(int j=1;j<=M;j++) {
                map[i][j]=text.charAt(j-1)-'0';
            }
        }
        
        count=1;
        if(N==1 && M==1) {
            System.out.println(count);
        } else {
            System.out.println(BFS());;
        }
    }

    private static int BFS() {
        queue.offer(new Point(1,1));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int row = point.row;
            int col = point.col;
            count++;
            for(int i=0;i<4;i++) {
                int y = row+dy[i];
                int x = col+dx[i];
                if(y>0 && y<=N && x>0 && x<=M && map[y][x]==1) {
                    map[y][x]=map[row][col]+1;
                    if(y==N && x==M) {
                        return map[y][x];
                    }
                    queue.offer(new Point(y,x));
                }
            }
        }
        return count;
    }
}
