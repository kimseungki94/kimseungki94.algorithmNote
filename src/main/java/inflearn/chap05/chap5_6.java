package inflearn.chap05;

import java.io.*;
import java.util.*;

public class chap5_6 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count;
    static String text, answer;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++) {
            queue.offer(i);
        }
    }

    public int Solution() {
        while (queue.size()!=1) {
            count++;
            if(count==M) {
                count=0;
                queue.poll();
            } else {
                queue.offer(queue.poll());
            }
        }
        return queue.poll();
    }


    public static void main(String[] args) throws Exception {
        chap5_6 main = new chap5_6();
        main.input();
        System.out.println(main.Solution());
    }
}

