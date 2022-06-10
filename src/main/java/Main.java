import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count, max, min;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
    }

    public static void func() {
        int minIndex = 0;
        boolean isSelected = false;
        for (int i = 0; i < N; i++) {
            min = arr[i];
            for (int j = i; j < N; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                    isSelected = true;
                }
            }
            if(isSelected) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
            isSelected=false;
        }
        for(int i=0;i<N;i++) sb.append(arr[i]+" ");
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
        System.out.println(sb.toString());
    }
}
