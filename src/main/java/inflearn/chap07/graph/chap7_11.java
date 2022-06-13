package inflearn.chap07.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chap7_11 {
    static int N, M, sum, max, min, count;
    static int[] arr;
    static boolean[] isSelected;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();
    static Node node;
    static Queue<Node> queue = new LinkedList<>();

    public static class Node {
        int data;
        Node lt, rt;

        public Node(int value) {
            data = value;
            lt = rt = null;
        }
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        arr = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            graph[X][Y] = 1;
        }
    }

    public static void DFS(int index) {
        if (index == N) {
            count++;
        } else {
            for (int col = 1; col <= N; col++) {
                if (graph[index][col] == 1 && arr[col] == 0) {
                    arr[col] = 1;
                    DFS(col);
                    arr[col] = 0;
                }
            }
        }
    }

    public static void Main(String[] args) throws Exception {
        input();
        arr[1]=1;
        DFS(1);
        System.out.println(count);
    }
}