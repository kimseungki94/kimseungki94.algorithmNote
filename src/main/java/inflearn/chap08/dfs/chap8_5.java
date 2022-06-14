package inflearn.chap08.dfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap8_5 {
    static int N, M, count;
    static int[] arr;
    static Queue<Integer> queue = new LinkedList<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            queue.offer(arr[i]);
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
    }

    public int BFS() {
        while (!queue.isEmpty()) {
            count++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int value = queue.poll();
                for (int X : arr) {
                    int data = value + X;
                    if (data == M) return count+1; // 동전의 값을 Queue에 삽입 전에 체크하기 때문에 +1를 추가해서 리턴
                    if (data < M) queue.offer(data);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        chap8_5 main = new chap8_5();
        main.input();
        System.out.println(main.BFS());
    }
}
