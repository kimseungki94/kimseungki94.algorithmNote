package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_7 {
    static int N, M, sum;
    static int[] arr;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node> list = new ArrayList<>();

    public class Node implements Comparable<Node> {
        int point;
        int next;
        int distance;

        public Node(int point, int next, int distance) {
            this.point = point;
            this.next = next;
            this.distance = distance;
        }


        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = i;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list.add(new Node(point, next, distance));
        }
        Collections.sort(list);
    }

    public int Find(int point) {
        if (arr[point] == point) return point;
        return arr[point] = Find(arr[point]);
    }

    public void Union(int point, int next) {
        if (point != next) arr[point] = next;
    }

    public static void main(String[] args) throws Exception {
        chap9_7 main = new chap9_7();
        main.input();
        for (Node node : list) {
            int point = main.Find(node.point);
            int next = main.Find(node.next);
            if (point != next) {
                sum += node.distance;
                main.Union(point, next);
            }
        }
        System.out.println(sum);
    }

}


