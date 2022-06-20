package inflearn.chap02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap2_3 {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr =new int[N];
        int[] arr2 =new int[N];
        int count=1;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr2[i]=Integer.parseInt(st.nextToken());
        }
        int max = arr[0];
        for(int i=0;i<N;i++) {
            if(arr[i]-arr2[i]==0) System.out.println("D");
            else if(arr[i]-arr2[i]==-2 || arr[i]-arr2[i]==1) System.out.println("A");
            else System.out.println("B");
        }
    }
}


