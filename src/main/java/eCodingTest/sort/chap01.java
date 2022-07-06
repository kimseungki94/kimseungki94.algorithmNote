package eCodingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class chap01 {
    static int N,M;
    static int[] arr1,arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr1 = new int[N];
        arr2 = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr2[i]=Integer.parseInt(st.nextToken());
        }
        quickSort(arr1,0,arr1.length-1);
        quickSort(arr2,0,arr2.length-1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start>=end) return;
        int pivot = start;
        int lt = start+1;
        int rt = end;

        while (lt<=rt) {
            while (lt<=end && arr[lt]<=arr[pivot]) lt++;
            while (rt>start && arr[rt]>=arr[pivot]) rt--;
            if(lt>rt) {
                int value = arr[pivot];
                arr[pivot]=arr[rt];
                arr[rt]=value;
                break;
            } else {
                int value = arr[lt];
                arr[lt]=arr[rt];
                arr[rt]=value;
            }
        }
        quickSort(arr,start,rt-1);
        quickSort(arr,rt+1,end);
    }
}
