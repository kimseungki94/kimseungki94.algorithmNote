package inflearn.chap02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chap2_6 {
    static int N, count;
    static int[] arr, data;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int max=0;
        st = new StringTokenizer(br.readLine());
        data = new int[N];
        for(int i=0;i<N;i++) {
            data[i]=Integer.parseInt(st.nextToken());
            max = Math.max(max, data[i]);
        }
        arr = new int[max+1];
        arr[0]=-1;
        arr[1]=-1;
        for(int i=2;i<=max;i++) {
            if(arr[i]==0) {
                for(int j=i*2;j<=max;j+=i) {
                    arr[j]=-1;
                }
            }
        }
        for(int i=0;i<N;i++) {
            int value = Integer.parseInt(sb.append(data[i]).reverse().toString());
            if(arr[value]==0) {
                System.out.print(value+" ");
            }
            sb.setLength(0);
        }
    }
}
