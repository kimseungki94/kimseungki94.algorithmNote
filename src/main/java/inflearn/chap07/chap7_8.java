package inflearn.chap07;


import java.io.*;
import java.util.*;

public class chap7_8 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] move = new int[]{5,1,-1};

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    public void Solution() {
        arr = new int[10001];
        System.out.println(BFS(N));
    }

    private int BFS(int data) {
        queue.offer(data);
        arr[data]=1;
        while (!queue.isEmpty()) {
            count++;
            int len = queue.size();
            for(int j=0;j<len;j++) {
                int start = queue.poll();
                for(int i=0;i<3;i++) {
                    int point = start+move[i];
                    if(point==M) return count;
                    if(point>=0 && arr[point]==0) {
                        arr[point]=1;
                        queue.offer(point);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        chap7_8 main = new chap7_8();
        main.input();
        main.Solution();
    }
}


