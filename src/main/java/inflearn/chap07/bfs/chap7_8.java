package inflearn.chap07.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chap7_8 {
    static int N, M, sum, max, min;
    static int[] arr;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] move = new int[]{-1, 1, 5};

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
    }

    public static int BFS(int location) {
        queue.offer(location);
        arr = new int[10001];
        arr[location] = 1;
        int depth=0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int data = queue.poll();
                for(int j=0;j<3;j++) {
                    int value=data+move[j];
                    if(value==M) return depth+1;
                    if(value>=0 && value<10001 && arr[value]==0) {
                        queue.offer(value);
                        arr[value]=1;
                    }
                }
            }
            depth++;
        }
        return depth;

    }


    public static void main(String[] args) throws Exception {
        input();
        System.out.println(BFS(N));
    }
}


