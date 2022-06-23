package inflearn.chap08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_15 {

    public class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, M, count, max, len, min;
    static int[][] map, dis;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static Queue<Position> queue = new LinkedList<>();
    static ArrayList<Position> house = new ArrayList<>();
    static ArrayList<Position> pizza = new ArrayList<>();
    static boolean flag = true;

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) house.add(new Position(i, j));
                if(map[i][j]==2) pizza.add(new Position(i, j));
            }
        }
        len = pizza.size();
        min = Integer.MAX_VALUE;
    }
    public void DFS(int count, int index) {
        if(count==M) {
            int sum=0;
            for(Position man : house) {
                int distance = 0;
                int pMin = Integer.MAX_VALUE;
                for(int data : arr) {
                    int pRow = pizza.get(data).row;
                    int pCol = pizza.get(data).col;
                    distance = Math.abs(man.row-pRow)+Math.abs(man.col-pCol);
                    pMin = Math.min(pMin,distance);
                }
                sum+=pMin;
            }
            min= Math.min(min, sum);
            return;
        }
        for(int i=index;i<len;i++) {
            arr[count]=i;
            DFS(count+1,i+1);
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_15 main = new chap8_15();
        main.input();
        main.DFS(0,0);
        System.out.println(min);
    }
}
