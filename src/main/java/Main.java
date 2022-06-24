import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, count, max, len, min;
    static int[][] map, dis;
    static int[] arr, distance;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> pQ = new PriorityQueue<>();

    public class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
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
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, cost));
            list.get(end).add(new Node(start, cost));
        }
    }

    private void Solution() {
        pQ.offer(new Node(1, 0));
        int sum = 0;
        while (!pQ.isEmpty()) {
            Node startNode = pQ.poll();
            int originPoint = startNode.end;
            if (arr[originPoint] == 0) {
                arr[originPoint] = 1;
                sum+=startNode.cost;
                for (Node node : list.get(originPoint)) {
                    int endPoint = node.end;
                    int endCost = node.cost;
                    if(arr[endPoint]==0) pQ.offer(new Node(endPoint, endCost));
                }
            }

            for (Node node : pQ) {
                System.out.println(node.end + " " + node.cost);
            }
            System.out.println();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        main.Solution();
    }
}
