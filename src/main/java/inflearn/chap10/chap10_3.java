package inflearn.chap10;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap10_3 {
    static int N, M, sum, count, max;
    static int[] arr, dy;
    static StringBuilder sb = new StringBuilder();


    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dy = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dy, 1);
    }


    public int DP() {
        for (int i = 1; i < N; i++) {
            int find = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) find = Math.max(find, dy[j] + 1);
            }
            dy[i] = find;
            max = Math.max(find, max);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        chap10_3 main = new chap10_3();
        main.input();
        System.out.println(main.DP());
    }

}

