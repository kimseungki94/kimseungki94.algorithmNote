package inflearn.chap02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap2_8 {
    static int N, count;
    static int[] arr, data;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++) {
            int rank =1;
            for(int j=0;j<N;j++) {
                if(i==j) continue;
                if(arr[i]<arr[j]) rank++;
            }
            sb.append(rank+" ");
        }
        System.out.println(sb.toString());
    }
}
