package inflearn.chap07;

import java.io.*;
import java.util.*;

public class chap7_9 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max,min;
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
        min = Integer.MAX_VALUE;
    }

    public void Solution() {
    }

    public void DFS(Node node, int vertex) {
        if(node.left==null && node.right==null) {
            min = Math.min(min, vertex);
        } else {
            DFS(node.left,vertex+1);
            DFS(node.right,vertex+1);
        }
    }

    public static void main(String[] args) throws Exception {
        chap7_9 main = new chap7_9();
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        main.input();
        main.Solution();
        main.DFS(node,0);
        System.out.println(min);
    }
}



