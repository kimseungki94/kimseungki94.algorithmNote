package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_4 {

    static int N, M, count, max, len, min;
    static int[][] map, dis;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Person> list = new ArrayList<>();
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    public class Person implements Comparable<Person>{
        int pay;
        int day;

        public Person(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }


        @Override
        public int compareTo(Person o) {
            return o.day-this.day;
        }
    }
    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            list.add(new Person(pay,day));
            max = Math.max(day,max);
        }
        Collections.sort(list);
    }

    private void Solution() {
        int sum=0;
        int j=0;
        for(int i=max;i>=1;i--) {
            for(;j<list.size();j++) {
                if(list.get(j).day!=i) break;
                pQ.offer(list.get(j).pay);
            }
            if(!pQ.isEmpty()) sum+=pQ.poll();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        chap9_4 main = new chap9_4();
        main.input();
        main.Solution();
        System.out.println(max);
    }
}
