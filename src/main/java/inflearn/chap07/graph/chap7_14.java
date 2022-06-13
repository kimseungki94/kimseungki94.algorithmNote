package inflearn.chap07.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chap7_14 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] arr;

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
    }

    public void BFS(int index) {
        queue.offer(index);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int index1 = queue.poll();
                for (int index2 : graph.get(index1)) {
                    if (arr[index2] == 0) {
                        arr[index2] = arr[index1] + 1;
                        queue.offer(index2);
                    }
                }
            }
        }
    }

    public void print() {
        for (int i = 2; i <= N; i++) System.out.println(i + " : " + arr[i]);
    }

    public static void main(String[] args) throws Exception {
        chap7_14 main = new chap7_14();
        main.input();
        main.BFS(1);
        main.print();
    }
}
