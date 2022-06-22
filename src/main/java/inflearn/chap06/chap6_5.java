package inflearn.chap06;


import java.io.*;
import java.util.*;

public class chap6_5 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    public String Solution() {
        answer = "U";
        for (int i = 0; i < N-1; i++) {
            if(arr[i]==arr[i+1]) return "D";
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        chap6_5 main = new chap6_5();
        main.input();
        System.out.println(main.Solution());
        System.out.println(Arrays.toString(arr));
    }
}

