package inflearn.chap06;


import java.io.*;
import java.util.*;

public class chap6_1 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

    }

    public void Solution() {
        for(int i=0;i<N;i++) {
            int index = i;
            for(int j=i+1;j<N;j++) {
                if(arr[index]>arr[j]){
                    index=j;
                }
            }
            int temp = arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }
    }


    public static void main(String[] args) throws Exception {
        chap6_1 main = new chap6_1();
        main.input();
        main.Solution();
        System.out.println(Arrays.toString(arr));
    }
}

