package inflearn.chap03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class chap3_1 {
    static int N, M, count, max;
    static int[] arr, data;
    static int[][] map;
    static int[] arr1,arr2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr1=new int[N];
        int lt,rt;
        lt=rt=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int value = Integer.parseInt(st.nextToken());
            arr1[i]=value;
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            int value = Integer.parseInt(st.nextToken());
            arr2[i]=value;
        }
        while (lt!=N || rt!=M) {
            if(lt==N) sb.append(arr2[rt++]+" ");
            else if(rt==M) sb.append(arr1[lt++]+" ");
            else {
                if(arr1[lt]<arr2[rt]) {
                    sb.append(arr1[lt++]+" ");
                } else {
                    sb.append(arr2[rt++]+" ");
                }
            }
        }
        System.out.println(sb.toString());
    }
}

