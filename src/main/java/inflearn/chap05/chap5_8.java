package inflearn.chap05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chap5_8 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static Queue<Person> queue = new LinkedList<>();

    public class Person {
        int order;
        int danger;

        public Person(int order, int danger) {
            this.order = order;
            this.danger = danger;
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int value = Integer.parseInt(st.nextToken());
            queue.offer(new Person(i,value));
            max = Math.max(max, value);
        }
    }

    public int Solution() {
        while (!queue.isEmpty()) {
            Person person = queue.poll();
            if(person.danger<max) {
                queue.offer(person);
            } else {
                count++;
                max=0;
                if(person.order==M) return count;
                for(Person p : queue) {
                    max = Math.max(max, p.danger);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) throws Exception {
        chap5_8 main = new chap5_8();
        main.input();
        System.out.println(main.Solution());
    }
}

