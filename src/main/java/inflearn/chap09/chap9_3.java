package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_3 {

    static int N, M, count, max, len, min;
    static int[][] map, dis;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Person> list = new ArrayList<>();

    public class Person implements Comparable<Person>{
        int time;
        char kind;

        public Person(int time, char kind) {
            this.time = time;
            this.kind = kind;
        }

        @Override
        public int compareTo(Person o) {
            if(this.time==o.time) return this.kind-o.kind;
            else return this.time-o.time;
        }

    }
    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Person(start,'S'));
            list.add(new Person(end,'E'));
        }
        Collections.sort(list);
    }

    private void Solution() {
        for(Person p : list) {
            if(p.kind=='S'){
                count++;
            } else {
                count--;
            }
            max = Math.max(max,count);
        }
    }

    public static void main(String[] args) throws Exception {
        chap9_3 main = new chap9_3();
        main.input();
        main.Solution();
        System.out.println(max);
    }
}
