import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M, emptySpace, answer = Integer.MAX_VALUE;
    public static int[][] map;

    public static List<Virus> list = new ArrayList<>();
    public static Virus[] activeVirus;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        activeVirus = new Virus[M];

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
            }

            time++;

            if (time >= answer) {
                return;
            }

            if (emptySpace <= 0) {
                answer = time;
            }
        }
    }

    public static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}