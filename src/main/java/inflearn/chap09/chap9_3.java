package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_3 {
    static int N, M, max, count, oStart, oEnd;
    static int[] arr;
    static int[] height, weight;
    static StringBuilder sb = new StringBuilder();
    static List<Meet> list = new ArrayList<>();

    public class Meet implements Comparable<Meet> {
        int start;
        char end;

        public Meet(int start, char end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet o) {
            if (this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Meet(Integer.parseInt(st.nextToken()), 'S'));
            list.add(new Meet(Integer.parseInt(st.nextToken()), 'E'));
        }
        Collections.sort(list);
    }

    public void solution() {
        for (Meet m : list) {
            if(m.end=='S') {
                count++;
            } else {
                count--;
            }
            max = Math.max(count,max);
        }
    }

    public static void main(String[] args) throws Exception {
        chap9_3 main = new chap9_3();
        main.input();
        main.solution();
        System.out.println(max);
    }
}

