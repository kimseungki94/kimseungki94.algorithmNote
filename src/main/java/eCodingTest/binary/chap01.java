package eCodingTest.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap01 {

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
            max = Math.max(max,arr[i]);
        }
        int min=0;
        int lt = min;
        int rt = max;
        System.out.println(lt+" "+rt);
        int result = 0;
        while (lt<=rt) {
            System.out.println(lt + " "+rt);
            int mid = (lt+rt)/2;
            int value=0;
            for(int i=0;i<N;i++) {
                if(arr[i]>mid) value+=arr[i]-mid;
            }
            if(value<M) {
                rt = mid-1;
            } else {
                result=mid;
                lt = mid+1;
            }
        }
        System.out.println(result);
    }
}
