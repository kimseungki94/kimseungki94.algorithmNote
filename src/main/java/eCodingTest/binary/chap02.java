package eCodingTest.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap02 {

    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int max=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int lt =0;
        int rt=N-1;
        while (lt<rt) {
            System.out.println(lt+" "+rt);
            int mid = (lt+rt)/2;
            if(arr[mid]<M){
                lt = mid+1;
            } else {
                rt=mid-1;
            }
        }
        System.out.println(lt);
        lt =0;
        rt=N-1;
        while (lt<rt) {
            System.out.println(lt+" "+rt);
            int mid = (lt+rt)/2;
            if(arr[mid]<=M){
                lt = mid+1;
            } else {
                rt=mid-1;
            }
        }
        System.out.println(lt+" "+rt);
        System.out.println(lt);
    }

}

