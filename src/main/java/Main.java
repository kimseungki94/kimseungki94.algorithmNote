import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max;
    static long count;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(count);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
    }

    public static void Solution() {
        int lt = 0;
        int rt = N-1;
        while (true) {
            if (lt>=rt) {
                break;
            } else if (arr[lt] + arr[rt] >= M) {
                if(arr[lt]+arr[rt]==M) count++;
                rt--;
            } else {
                lt++;
            }
        }
    }
}