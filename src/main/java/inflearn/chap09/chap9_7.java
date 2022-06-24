package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_7 {

    static int N, M, count, max, len, min;
    static int[][] map, dis;
    static int[] arr, distance;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node> list = new ArrayList<>();
    static PriorityQueue<Node> pQ = new PriorityQueue<>();

    public class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

    public int find(int index) {
        if (arr[index] == index) return index;
        else {
            return arr[index] = find(arr[index]);
        }
    }

    public void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if (findA != findB) {
            arr[findA] = b;
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        distance = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end, cost));
        }
        Collections.sort(list);
    }

    private void Solution() {
        int sum = 0;
        for(Node node : list) {
            int start = find(node.start);
            int end = find(node.end);
            if(start!=end) {
                sum+=node.cost;
                union(start,end);
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        chap9_7 main = new chap9_7();
        main.input();
        main.Solution();
    }
}
