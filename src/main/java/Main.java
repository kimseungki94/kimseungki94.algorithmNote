import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, count, max, min;
    static boolean flag = true;
    static boolean[][] isSelected;
    static boolean[][] waterIsSelected;
    static char[][] map;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static Queue<Point> waterQueue = new LinkedList<>();
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        min = Integer.MAX_VALUE;
        isSelected = new boolean[N][M];
        waterIsSelected = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            for (int j = 0; j < M; j++) {
                char value = data.charAt(j);
                map[i][j] = value;
                if (value == 'S') {
                    queue.offer(new Point(i, j, 0));
                    isSelected[i][j]=true;
                }
                if (value == '*') {
                    waterQueue.offer(new Point(i, j, 0));
                    waterIsSelected[i][j]=true;
                }
            }
        }

        int value = BFS();
        if(value==-1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(value);
        }
    }

    public static class Point {
        int row;
        int col;
        int move;

        public Point(int row, int col, int move) {
            this.row = row;
            this.col = col;
            this.move = move;
        }
    }

    public static int BFS() {
        while (!queue.isEmpty()) {
            waterMove();
            int len = queue.size();
            for (int t = 0; t < len; t++) {
                Point point = queue.poll();
                int Y = point.row;
                int X = point.col;
                for (int i = 0; i < 4; i++) {
                    int row = Y + dy[i];
                    int col = X + dx[i];
                    if (row < 0 || row >= N || col < 0 || col >= M) continue;
                    if(map[row][col]=='D') return point.move+1;
                    if (map[row][col] != '.') continue;
                    if(isSelected[row][col] || waterIsSelected[row][col]) continue;
                    isSelected[row][col]=true;
                    queue.offer(new Point(row,col,point.move+1));
                    String a = "aa";
                    Map<String,String> map = new HashMap<>();
                }
            }
        }
        return -1;
    }

    public static void waterMove() {
        int len = waterQueue.size();
        for (int t = 0; t < len; t++) {
            Point point = waterQueue.poll();
            for (int i = 0; i < 4; i++) {
                int row = point.row + dy[i];
                int col = point.col + dx[i];
                if (row < 0 || row >= N || col < 0 || col >= M) continue;
                if (map[row][col] != '.') continue;
                if (waterIsSelected[row][col]) continue;
                waterIsSelected[row][col] = true;
                waterQueue.add(new Point(row, col, 0));
            }
        }
    }
}