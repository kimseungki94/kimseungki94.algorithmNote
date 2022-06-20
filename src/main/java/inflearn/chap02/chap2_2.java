package inflearn.chap02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap2_2 {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr =new int[N];
        int count=1;
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N;i++) {
            if(arr[i-1]<arr[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}

