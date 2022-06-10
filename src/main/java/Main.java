import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void func() {
        Arrays.sort(arr);
        int lt, rt, mid;
        lt = mid = 0;
        rt = N - 1;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (arr[mid] == M) {
                break;
            } else if (arr[mid] > M) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(mid + 1);
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
