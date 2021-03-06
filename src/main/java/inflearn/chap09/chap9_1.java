package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_1 {

    public class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, M, count, max, len, min;
    static int[][] map, dis;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Person> list = new ArrayList<>();

    public class Person implements Comparable<Person>{
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height-this.height;
        }

    }
    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Person(height,weight));
        }
        Collections.sort(list);
    }

    private void Solution() {
        for(int i=0;i<N;i++) {
            int weight = list.get(i).weight;
            if(max<weight) {
                max = weight;
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        chap9_1 main = new chap9_1();
        main.input();
        main.Solution();
    }
}
