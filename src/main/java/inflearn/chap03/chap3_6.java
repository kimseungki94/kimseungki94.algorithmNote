package inflearn.chap03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class chap3_6 {
    static int N, M, count, max;
    static int[] arr;
    static int[][] map;
    static int[] arr1, arr2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> memory = new ArrayList<>();

        int lt = 0;
        for (int rt = 0; rt < N; rt++) {
            if (arr[rt] == 0) {
                if (memory.size() == M) {
                    lt = memory.remove(0);
                    arr[lt] = 0;
                    while (arr[lt] == 0) lt++;
                }
                memory.add(rt);
                arr[rt] = 1;
            }
            max = Math.max(max, rt - lt + 1);
        }
        System.out.println(max);
    }
}
