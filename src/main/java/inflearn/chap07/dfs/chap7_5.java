package inflearn.chap07.dfs;

import java.io.*;

public class chap7_5 {
    static int N, M, sum, max;
    static int[] arr;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    static Node node;
    public static class Node{
        int data;
        Node lt, rt;

        public Node(int value) {
            data = value;
            lt=rt=null;
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
    }

    public static void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data+" ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        node = new Node(1);
        node.lt = new Node(2);
        node.rt = new Node(3);
        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);
        node.rt.lt = new Node(6);
        node.rt.rt = new Node(7);
        DFS(node);
    }
}
