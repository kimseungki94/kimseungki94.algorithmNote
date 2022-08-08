import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M, max;
    static int[] arr;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        isVisited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        DFS(0,0);
        System.out.println(max);
    }

    private static void DFS(int sum, int limit) {
        if (limit == M) return;
        if (limit == 3) {
            if (max < sum && sum <= M) {
                max = sum;
            }
            return;
        }
        for (int i = limit; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sum += arr[i];
                DFS(sum, limit + 1);
                sum -= arr[i];
                isVisited[i] = false;
            }
        }
    }
}