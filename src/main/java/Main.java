
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count, max;
    static int a, b;
    static String text, answer;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        select = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    public int Solution() {
        int lt = Arrays.stream(arr).min().getAsInt();
        int rt = Arrays.stream(arr).max().getAsInt();
        int mid = 0;
        int temp=0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            System.out.println(lt + " " + rt+" "+count(mid));
            int size = count(mid);
            if (size >= M) {
                lt = mid + 1;
            } else if (size < M) {
                temp=mid;
                rt = mid - 1;
            }
        }
        System.out.println(count(3));
        System.out.println(temp);
        return mid+1;
    }

    public int count(int m) {
        int lt=0;
        int horse=1;
        System.out.println("---");
        for(int rt = 0;rt<N;rt++) {
            System.out.println();
            if(rt-lt>=m) {
                lt=rt;
                horse++;
            }
        }
        return horse;
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        System.out.println(main.Solution());
    }
}

