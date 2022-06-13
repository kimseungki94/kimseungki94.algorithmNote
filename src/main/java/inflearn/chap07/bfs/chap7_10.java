package inflearn.chap07.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class chap7_10 {
    static int N, M, sum, max, min;
    static int[] arr;
    static boolean[] isSelected;
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
        N = 7;
        arr = new int[N + 1];
        isSelected = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        min = Integer.MAX_VALUE;
    }

    public static int BFS(Node root) {
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                if(node.lt==null && node.rt==null) {
                    return depth;
                } else {
                    if (node.lt != null) queue.offer(node.lt);
                    if (node.rt != null) queue.offer(node.rt);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) throws Exception {
        input();
        node = new Node(1);
        node.lt = new Node(2);
        node.rt = new Node(3);
        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);
        System.out.println(BFS(node));
    }
}

