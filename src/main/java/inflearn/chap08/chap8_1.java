package inflearn.chap08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class chap8_1 {
    static int N, M, sum;
    static String answer;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] arr, check;

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        check = new int[N + 1];
        sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        answer="NO";
    }

    public void DFS(int index) {
        if (index == N + 1) {
            int value=0;
            for(int i=1;i<=N;i++) if(check[i]==1) value+=arr[i];
            if(value==sum-value) {
                answer="YES";
            }
        } else {
            for (int i = index; i <= N; i++) {
                check[i] = 1;
                DFS(i + 1);
                check[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_1 main = new chap8_1();
        main.input();
        main.DFS(arr[1]);
        System.out.println(answer);
    }
}
