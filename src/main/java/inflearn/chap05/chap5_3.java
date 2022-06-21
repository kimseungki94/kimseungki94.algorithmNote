package inflearn.chap05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap5_3 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count;
    static String text, answer;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        select = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            select[i] = Integer.parseInt(st.nextToken());
        }
    }

    public int Solution() {
        for (int i = 0; i < M; i++) {
            int value = pick(select[i]);
            if (value > 0) {
                if (!stack.isEmpty() && stack.peek() == value) {
                    stack.pop();
                    count += 2;
                } else {
                    stack.push(value);
                }
            }
        }
        return count;
    }

    public int pick(int line) {
        int value = -1;
        for (int row = 1; row <= N; row++) {
            if (map[row][line] > 0) {
                value = map[row][line];
                map[row][line] = 0;
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        chap5_3 main = new chap5_3();
        main.input();
        System.out.println(main.Solution());
    }
}

