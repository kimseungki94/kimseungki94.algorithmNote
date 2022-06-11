package inflearn.chap07.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class chap7_6 {
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
        N = 3;
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
    }

    public static void DFS(int index, String text) {
        if(index>N) {
            return;
        } else {
            for(int i=index;i<=N;i++) {
                String temp = text;
                text+=arr[i]+" ";
                DFS(i+1, text);
                System.out.println(text);
                text = temp;
            }
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
        DFS(1, "");
    }
}

