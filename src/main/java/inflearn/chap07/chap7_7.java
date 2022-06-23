package inflearn.chap07;

import java.io.*;
import java.util.*;

public class chap7_7 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();
    static Queue<Node> queue = new LinkedList<>();

    public static class Node{
        Node left;
        Node right;
        int point;

        public Node(int point) {
            this.point = point;
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //N = Integer.parseInt(st.nextToken());
    }

    public void Solution() {
    }

    public void BFS(Node data) {
        queue.offer(data);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.point+" ");
            if(node.left!=null && node.right!=null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap7_7 main = new chap7_7();
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        main.input();
        main.Solution();
        main.BFS(node);
    }
}


