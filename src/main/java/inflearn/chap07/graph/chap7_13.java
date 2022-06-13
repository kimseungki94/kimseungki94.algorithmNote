package inflearn.chap07.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class chap7_13 {
    static int N, M, sum, max, min, count;
    static int[] arr;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
    }

    public static void DFS(int index) {
        if (index == N) {
            count++;
        } else {
            for(int i=0;i<graph.get(index).size();i++) {
                int value = graph.get(index).get(i);
                if(arr[value]==0) {
                    arr[value]=1;
                    DFS(value);
                    arr[value]=0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        arr[1]=1;
        DFS(1);
        System.out.println(count);
    }
}

