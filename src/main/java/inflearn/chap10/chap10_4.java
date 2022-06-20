package inflearn.chap10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap10_4 {
    static int N, M, sum, count, max;
    static int[] arr, dy;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Stone> list = new ArrayList<>();

    public class Stone implements Comparable<Stone> {
        int size;
        int length;
        int weight;

        public Stone(int size, int length, int weight) {
            this.size = size;
            this.length = length;
            this.weight = weight;
        }

        @Override
        public int compareTo(Stone o) {
            return o.size - this.size;
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dy = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Stone(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
    }


    public int DP() {
        dy[0] = list.get(0).length;
        for (int i = 1; i < N; i++) {
            dy[i] = list.get(i).length;
            int sum = list.get(i).length;
            for (int j = i-1; j >= 0; j--) {
                if (list.get(i).weight < list.get(j).weight) dy[i] = Math.max(sum + dy[j], dy[i]);
            }
        }
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dy[i]);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        chap10_4 main = new chap10_4();
        main.input();
        System.out.println(main.DP());
    }

}


