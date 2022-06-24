package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_5 {

    static int N, M, count, max, len, min;
    static int[][] map, dis;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> pQ = new PriorityQueue<>(Collections.reverseOrder());
    public class Node implements Comparable<Node>{
        int point;
        int cost;

        public Node(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<=N;i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end,cost));
        }
        arr = new int[N+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
    }

    private void Solution() {
        BFS();
        for(int i=2;i<=N;i++) {
            if(arr[i]==Integer.MAX_VALUE)System.out.println(i+" : Impossible");
            else System.out.println(i+" : "+arr[i]);
        }
    }

    private void BFS() {
        pQ.offer(new Node(1,0));
        arr[1]=0;
        while (!pQ.isEmpty()) {
            Node data = pQ.poll();
            for(Node node : list.get(data.point)) {
                if(arr[node.point]>arr[data.point]+node.cost) {
                    arr[node.point]=arr[data.point]+node.cost;
                    pQ.offer(new Node(node.point, arr[node.point]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap9_5 main = new chap9_5();
        main.input();
        main.Solution();
    }
}
