package inflearn.chap02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class chap2_5 {
    static int N, count;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for(int i=2;i<=N;i++) {
            if(arr[i]==0) {
                count++;
                for(int j=i*2;j<=N;j+=i) {
                    arr[j]=-1;
                }
            }
        }
        System.out.println(count);
    }
}
