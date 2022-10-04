import java.io.*;
import java.util.*;

public class Main {
    static long N, M, T, count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.println(count);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    public static void Solution() {
        long limit = 100 * M / N;

        if (limit >= 99) {
            count = -1;
        } else {

            long lt = 0;
            long rt = 2_000_000_000;

            while (lt < rt) {
                long mid = (lt + rt) / 2;

                long ret = 100 * (M + mid) / (N + mid);

                if (ret > limit) {
                    rt = mid;
                } else {
                    lt = mid + 1;
                }
            }
            count = rt;
        }
    }
}