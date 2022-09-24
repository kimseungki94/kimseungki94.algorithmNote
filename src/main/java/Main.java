import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, count;
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        input();
        findSquare();
        System.out.println(count);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());
            printing(x, y, getDirections(direction, generation));
        }

    }

    public static List<Integer> getDirections(int direction, int generation) {
        List<Integer> directions = new ArrayList<>();
        directions.add(direction);
        while (generation-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int fixDirection = (directions.get(i) + 1) % 4;
                directions.add(fixDirection);
            }
        }
        return directions;
    }

    public static void printing(int x, int y, List<Integer> directions) {
        map[x][y] = true;
        for (int direction : directions) {
            y = y + dy[direction];
            x = x + dx[direction];
            map[x][y] = true;
        }
    }

    public static void findSquare() {
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1])
                    count++;
            }
        }
    }
}
