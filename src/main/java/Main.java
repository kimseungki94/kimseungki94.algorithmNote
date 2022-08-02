import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
import java.util.*;

public class Main {
    public static int N, M, emptySpace, answer = Integer.MAX_VALUE;
    public static int[][] map;

    public static List<Virus> list = new ArrayList<>();
    public static Virus[] activeVirus;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
=======
<<<<<<< HEAD
import java.util.*;
=======
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
>>>>>>> ec1d5845cdf660fd7e17737676432c77efedcbe7

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

<<<<<<< HEAD
    public static void main(String[] args) throws IOException {
=======
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
>>>>>>> ec1d5845cdf660fd7e17737676432c77efedcbe7
>>>>>>> bf416fcee00f87b8274018ddb63aa69fd158b61d
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
<<<<<<< HEAD

        map = new int[N][N];
        activeVirus = new Virus[M];

=======
<<<<<<< HEAD
        map = new char[N][M];
        min = Integer.MAX_VALUE;
        isSelected = new boolean[N][M];
        waterIsSelected = new boolean[N][M];
>>>>>>> bf416fcee00f87b8274018ddb63aa69fd158b61d
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    emptySpace++;
                } else if (map[i][j] == 2) {
                    list.add(new Virus(i, j));
                }
            }
        }

        if (emptySpace == 0) {
            System.out.println(0);
            return;
        }

        combination(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void combination(int depth, int start) {
        if (depth == M) {
            spread(emptySpace);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            activeVirus[depth] = list.get(i);
            combination(depth + 1, i + 1);
        }
    }

    public static void spread(int emptySpace) {
        Queue<Virus> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];

        for (Virus v : activeVirus) {
            queue.add(v);
            visit[v.x][v.y] = true;
        }

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Virus cur = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (visit[nx][ny] || map[nx][ny] == 1) continue;

                    if (map[nx][ny] == 0) {
                        emptySpace--;
                    }

                    queue.add(new Virus(nx, ny));
                    visit[nx][ny] = true;
                }
<<<<<<< HEAD
            }

            time++;

            if (time >= answer) {
                return;
            }

            if (emptySpace <= 0) {
                answer = time;
=======
=======
        arr = new int[N];
        int max=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        int min=0;
        int lt = min;
        int rt = max;
        System.out.println(lt+" "+rt);
        while (lt<=rt) {
            System.out.println(lt + " "+rt);
            int mid = (lt+rt)/2;
            int value=0;
            for(int i=0;i<N;i++) {
                if(arr[i]>mid) value+=arr[i]-mid;
            }
            if(value==M) {
                System.out.println(value);
                break;
            } else if(value<M) {
                rt = mid-1;
            } else {
                lt = mid+1;
>>>>>>> ec1d5845cdf660fd7e17737676432c77efedcbe7
>>>>>>> bf416fcee00f87b8274018ddb63aa69fd158b61d
            }
        }
    }
<<<<<<< HEAD

    public static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
=======
<<<<<<< HEAD

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
=======
>>>>>>> ec1d5845cdf660fd7e17737676432c77efedcbe7
>>>>>>> bf416fcee00f87b8274018ddb63aa69fd158b61d
}