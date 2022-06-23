package inflearn.chap08;
import java.io.*;
import java.util.*;

public class chap8_1 {
    static int[] arr, select;
    static int N, M, count, max, min, sum;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        select = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
    }

    public void Solution() {
        sum = Arrays.stream(arr).sum();
        answer="NO";
        DFS(0,0);
    }
    public void DFS(int index,int value) {
        if(answer.equals("YES")) return;

        if(index==N) {
            int data = sum-value;
            if(data==value) {
                answer= "YES";
            }
        } else {
            DFS(index+1,value+arr[index]);
            DFS(index+1,value);
        }
    }

    public static void main(String[] args) throws Exception {
        chap8_1 main = new chap8_1();
        main.input();
        main.Solution();
        System.out.println(answer);
    }
}


