package inflearn.chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap9_6 {
    static int N, M;
    static int[] arr;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static PriorityQueue<Integer> pQ = new PriorityQueue<>();
    static int[] friendShip;

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        friendShip = new int[N+1];
        for(int i=1;i<=N;i++) friendShip[i]=i;
        int me;
        int you;
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            me = Integer.parseInt(st.nextToken());
            you = Integer.parseInt(st.nextToken());
            Union(me,you);
            System.out.println(Arrays.toString(friendShip));
        }
        st = new StringTokenizer(br.readLine());
        me = Integer.parseInt(st.nextToken());
        you = Integer.parseInt(st.nextToken());
        if(Find(me)==Find(you)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public int Find(int me) {
        if(friendShip[me]==me) return me;
        return friendShip[me]=Find(friendShip[me]);
    }

    public void Union(int a, int b) {
        int me = Find(a);
        int you = Find(b);
        if(friendShip[me]!=friendShip[you]) friendShip[me] = you;
    }

    public static void main(String[] args) throws Exception {
        chap9_6 main = new chap9_6();
        main.input();

    }

}


