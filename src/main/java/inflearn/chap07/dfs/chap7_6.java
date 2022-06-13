package inflearn.chap07.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
    }

    public static void DFS(int count) {
        if (count > N) {
            for(int i=1;i<=N;i++) if(arr[i]==1) System.out.print(i+" ");
            System.out.println();
            return;
        } else {
            arr[count]=1;
            DFS(count+1);
            arr[count]=0;
            DFS(count+1);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        DFS(1);
    }
}

