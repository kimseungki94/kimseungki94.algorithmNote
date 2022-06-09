import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count, max;
    static Queue<Person> queue = new LinkedList<>();

    public static class Person {
        int order;
        int depth;

        public Person(int order, int depth) {
            this.order = order;
            this.depth = depth;
        }

        public int getOrder() {
            return order;
        }

        public int getDepth() {
            return depth;
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
            queue.offer(new Person(i, data));
            max = Math.max(data, max);
        }
    }

    public static int func() {
        while (!queue.isEmpty()) {
            if (max == queue.peek().getDepth()) {
                count++;
                if (queue.poll().getOrder() == M) {
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
            max = Math.max(max, person.getDepth());
            queue.offer(person);
        }
    }


    public static void main(String[] args) throws Exception {
        input();
        System.out.println(func());
    }
}
