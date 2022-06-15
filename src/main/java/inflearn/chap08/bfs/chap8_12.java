package inflearn.chap08.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chap8_12 {
    public class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, M, count, max;
    static int[][] map, dis;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    static Queue<Position> queue = new LinkedList<>();
    static boolean flag = true;

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dis = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) queue.offer(new Position(i, j));
            }
        }
    }

    public int BFS() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Position position = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int y = position.row + dy[j];
                    int x = position.col + dx[j];
                    if (x >= 0 && x < M && y >= 0 && y < N && map[y][x] == 0) {
                        map[y][x] = 1;
                        dis[y][x] = dis[position.row][position.col]+1;
                        queue.offer(new Position(y, x));
                    }
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        chap8_12 main = new chap8_12();
        main.input();
        main.BFS();

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==0) {
                    flag=false;
                    break;
                }
               max = Math.max(max, dis[i][j]);
            }
        }
        if(flag) {
            System.out.println(max);
        } else {
            System.out.println(-1);
        }
    }
}
