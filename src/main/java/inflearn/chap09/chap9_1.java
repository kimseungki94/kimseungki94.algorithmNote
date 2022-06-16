package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_1 {
    static int N, M, max, count;
    static int[] arr;
    static int[] height, weight;
    static StringBuilder sb = new StringBuilder();
    static List<Person> list = new ArrayList<>();

    public class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
    }

    public void solution() {
        for(int i=0;i<N;i++) {
            int weight = list.get(i).weight;
            if(weight>max) {
                count++;
                max=weight;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap9_1 main = new chap9_1();
        main.input();
        main.solution();
        System.out.println(count);
    }
}

