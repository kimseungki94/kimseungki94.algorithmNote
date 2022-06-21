package inflearn.chap06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class chap6_7 {
    static int N, M, count, max, min;
    static int[] arr, memory;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Map> list = new ArrayList<>();

    public static class Map implements Comparable<Map> {
        int row;
        int col;

        public Map(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Map o) {
            if (this.row == o.row) return this.col - o.col;
            else return this.row-o.row;
        }
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Map(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    public static void func() {
        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i).row + " " + list.get(i).col);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
