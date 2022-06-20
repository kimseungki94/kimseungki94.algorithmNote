package inflearn.chap02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class chap2_4 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        System.out.println(DFS(N));
        System.out.println(Arrays.toString(arr));
    }

    public static int DFS(int index) {
        if (arr[index] > 0) return arr[index];
        if (index == 1 || index == 2) return arr[index] = 1;
        else return arr[index] = DFS(index-1) + DFS(index-2);
    }
}
