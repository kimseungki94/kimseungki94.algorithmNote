package inflearn.chap10;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap10_6 {

    static int N, M;
    static int[] arr,dp,coin;
    static StringBuilder sb = new StringBuilder();

    public class Work implements Comparable<Work>{
        int score;
        int time;

        public Work(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(Work o) {
            return o.time-this.time;
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Work> list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Work(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        dp=new int[M+1];
        dp[0]=0;
        for(int i=0;i<N;i++) {
            for(int j=M;j>=list.get(i).time;j--) {
                dp[j]=Math.max(dp[j],dp[j-list.get(i).time]+list.get(i).score);
            }
            System.out.println(Arrays.toString(dp));
        }

    }
    public static void main(String[] args) throws Exception {
        chap10_6 main = new chap10_6();
        main.input();
    }
}
