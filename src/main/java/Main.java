import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, max;
    static int[] arr, dp;
    static boolean isSelected;
    static String target;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
    }
}
