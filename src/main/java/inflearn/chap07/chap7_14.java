package inflearn.chap07;

import java.io.*;
import java.util.*;

public class chap7_14 {
    static int[] arr, select;
    static int N, M, count, max, min;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        select = new int[N + 1];
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(start).add(end);
        }
        arr[1] = 0;
        select[1] = 1;
    }

    public void Solution() {
        BFS();
    }

    private void BFS() {
        queue.offer(1);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            for (int end : map.get(start)) {
                if (select[end] == 0) {
                    arr[end] = arr[start] + 1;
                    queue.offer(end);
                    select[end]=1;
                }
            }
            System.out.println(queue);
        }
    }


    public static void main(String[] args) throws Exception {
        chap7_14 main = new chap7_14();
        main.input();
        main.Solution();
        System.out.println(Arrays.toString(arr));
    }
}



