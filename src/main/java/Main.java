import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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
            if(this.weight==o.weight) return this.height-o.height;
            else return this.weight-o.weight;
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
            max = Math.max(max, weight);
            list.add(new Person(height,weight));
        }
        arr = new int[max+1];
        Collections.sort(list);
    }

    private void Solution() {
        int value = 0;
        for(Person p : list) {
            if(p.height>=value) {
                count++;
                value = p.weight;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        main.Solution();
    }
}
