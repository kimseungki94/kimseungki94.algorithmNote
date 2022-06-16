package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_5 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    static PriorityQueue<Node> pQ = new PriorityQueue<>();

    public class Node implements Comparable<Node>{
        int point;
        int distance;

        public Node(int point, int distance) {
            this.point = point;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance-o.distance;
        }
    }



    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for(int i=0;i<=N;i++) {
            map.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            map.get(node).add(new Node(nextNode,distance));
        }
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1]=0;
    }

    public void BFS() {
        pQ.offer(new Node(1,0));
        while (!pQ.isEmpty()) {
            Node node = pQ.poll();
            if(node.distance>arr[node.point]) continue;
            for(Node nodeData : map.get(node.point)) {
                if(arr[nodeData.point]>arr[node.point]+nodeData.distance){
                    arr[nodeData.point]=arr[node.point]+nodeData.distance;
                    pQ.offer(new Node(nodeData.point, node.distance+nodeData.distance));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap9_5 main = new chap9_5();
        main.input();
        main.BFS();
        for(int i=2;i<=N;i++) {
            if(arr[i]==Integer.MAX_VALUE) System.out.println(i+" : impossible");
            else System.out.println(i+" : " + arr[i]);
        }
    }
}

