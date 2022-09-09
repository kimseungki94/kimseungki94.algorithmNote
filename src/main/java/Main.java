import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, K, min, max;
    static int[] arr, answer;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] isChecked;
    static ArrayList<Point> list;

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(isMove());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int isMove() {
        int count = 0;
        while (true) {
            boolean flag = false;
            isChecked = new boolean[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(!isChecked[i][j]) {
                        int sum = BFS(i,j);
                        if(list.size()>1) {
                            changeArea(sum);
                            flag=true;
                        }
                    }
                }
            }
            if(!flag) return count;
            count++;
        }
    }

    private static int BFS(int Y, int X) {
        Queue<Point> queue= new LinkedList<>();
        queue.offer(new Point(Y,X));
        list = new ArrayList<>();
        list.add(new Point(Y,X));
        isChecked[Y][X]=true;
        int sum = map[Y][X];
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0;i<4;i++) {
                int row = p.row+dy[i];
                int col = p.col+dx[i];
                if(row<0 || row>=N || col<0 || col>=N || isChecked[row][col]) continue;
                int diff = Math.abs(map[row][col]-map[p.row][p.col]);
                if(diff>=M && diff<=K) {
                    queue.offer(new Point(row,col));
                    list.add(new Point(row,col));
                    sum+=map[row][col];
                    isChecked[row][col]=true;
                }
            }
        }
        return sum;
    }

    private static void changeArea(int man) {
        int average = man/list.size();
        for(Point p : list) {
            map[p.row][p.col]=average;
        }
    }
}