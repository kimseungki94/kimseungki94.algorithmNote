package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_8 {
    static int N, M, sum;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Edge> pQ = new PriorityQueue<>();
    static ArrayList<ArrayList<Edge>> list = new ArrayList<>();

    public class Edge implements Comparable<Edge> {
        int next;
        int distance;

        public Edge(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        for (int i = 0; i <= M; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list.get(point).add(new Edge(next, distance));
            list.get(next).add(new Edge(point, distance));
        }
    }

    public void BFS() {
        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge origin = pQ.poll();
            if(arr[origin.next]==0) {
                arr[origin.next]=1;
                sum+=origin.distance;
                for(Edge edge : list.get(origin.next)) {
                    if(arr[edge.next]==0) pQ.offer(edge);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap9_8 main = new chap9_8();
        main.input();
        main.BFS();
        System.out.println(sum);
    }

}


