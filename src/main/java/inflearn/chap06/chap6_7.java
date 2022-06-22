package inflearn.chap06;

import java.io.*;
import java.util.*;

public class chap6_7 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        select = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            select[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void Solution() {
        for (int i = 1; i < N; i++) {
            int temp = arr[i], j;
            int temp2 = select[i];
            for (j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                    select[j + 1] = select[j];
                } else if (temp == arr[j]) {
                    if(temp2<select[j]){
                        arr[j + 1] = arr[j];
                        select[j+1]=select[j];
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
            select[j + 1] = temp2;
        }
        for (int i = 0; i < N; i++) sb.append(arr[i] + " " + select[i] + "\n");
    }

    public static void main(String[] args) throws Exception {
        chap6_7 main = new chap6_7();
        main.input();
        main.Solution();
        System.out.println(sb.toString());
    }
}

