package inflearn.chap10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap10_4 {

    static int N, M;
    static int[] arr,dp;
    static StringBuilder sb = new StringBuilder();

    public class Stone implements Comparable<Stone>{
        int s;
        int h;
        int w;

        public Stone(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }


        @Override
        public int compareTo(Stone o) {
            return o.s-this.s;
        }
    }
    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Stone> list = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Stone(s,h,w));
        }
        Collections.sort(list);
        for(int i=0;i<N;i++) {
            dp[i]=list.get(i).h;
        }
        System.out.println(Arrays.toString(dp));
        for(int i=1;i<N;i++) {
            Stone before = list.get(i);
            int max_h = 0;
            for(int j=i-1;j>=0;j--) {
                Stone after = list.get(j);
                if(before.w<after.w && dp[j]>max_h) {
                    max_h=Math.max(max_h,dp[j]);
                }
                dp[i]=Math.max(dp[i],max_h+before.h);
            }
            System.out.println(Arrays.toString(dp));
        }
    }
    public static void main(String[] args) throws Exception {
        chap10_4 main = new chap10_4();
        main.input();
    }
}
