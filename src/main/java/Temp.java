import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Temp {
    static int N, M, K, max, sum, min, apple, direction;
    static int[][] map;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Queue<Integer> list = new LinkedList<>();
    static HashMap<Integer, String> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        input();
        Solution();
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int Y = Integer.parseInt(st.nextToken()) - 1;
            int X = Integer.parseInt(st.nextToken()) - 1;
            map[Y][X] = 1;
        }
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            hashMap.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }
    }

    public static void Solution() {
        DFS();
    }

    public static void DFS() {
        list.add(0);
        int time = 0;
        int turn = 0;
        int x = 0;
        int y = 0;
        while (true) {
            time++;
            int Y = y + dy[turn];
            int X = x + dx[turn];
            if (X < 0 || Y < 0 || X >= N || Y >= N) break;
            if (list.contains(Y * N + X)) break;
            if (map[Y][X] == 1) {
                map[Y][X] = 0;
                list.add(Y * N + X);
            } else {
                list.add(Y * N + X);
                list.poll();
            }
            if (hashMap.containsKey(time)) {
                if (hashMap.get(time).equals("D")) {
                    turn += 1;
                    if (turn == 4) turn = 0;
                } else {
                    turn -= 1;
                    if (turn == -1) turn = 3;
                }
            }
            y = Y;
            x = X;
        }
        System.out.println(time);
    }
}