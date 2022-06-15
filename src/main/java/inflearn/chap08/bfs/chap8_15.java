package inflearn.chap08.bfs;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_15 {

    public class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, M, min;
    static int[][] map;
    static int[] arr;
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        arr = new int[M];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) house.add(new Point(i, j));
                if (value == 2) chicken.add(new Point(i, j));
            }
        }
    }

    public void DFS(int index, int value) {
        if (index == M) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int data = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    data = Math.min(data, calculate(house.get(i), chicken.get(arr[j])));
                }
                sum += data;
            }
            min = Math.min(min, sum);
            return;
        }
        for (int i = value; i < chicken.size(); i++) {
            arr[index] = i;
            DFS(index + 1, i + 1);
        }
    }

    public int calculate(Point house, Point chicken) {
        return Math.abs(house.row - chicken.row) + Math.abs(house.col - chicken.col);
    }

    public static void main(String[] args) throws Exception {
        chap8_15 main = new chap8_15();
        main.input();
        main.DFS(0, 0);
        System.out.println(min);
    }
}
