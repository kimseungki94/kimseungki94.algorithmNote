package inflearn.chap05.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chap5_8 {
    static int N, M, count, max;
    static Queue<Person> queue = new LinkedList<>();

    public static class Person {
        int order;
        int depth;

        public Person(int order, int depth) {
            this.order = order;
            this.depth = depth;
        }
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        max = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(st.nextToken());
            queue.offer(new Person(i,data));
            max = Math.max(data, max);
        }
    }

    public static int func() {
        while (!queue.isEmpty()) {
            if (max == queue.peek().depth) {
                count++;
                Person p = queue.poll();
                if (p.depth == M) {
                    return count;
                }
                max = 0;
                findMax();
            } else {
                queue.offer(queue.poll());
            }
        }
        return count;
    }

    private static void findMax() {
        for (int i = 0; i < queue.size(); i++) {
            Person person = queue.poll();
            max = Math.max(max, person.depth);
            queue.offer(person);
        }
    }


    public static void main(String[] args) throws Exception {
        input();
        System.out.println(func());
    }
}

