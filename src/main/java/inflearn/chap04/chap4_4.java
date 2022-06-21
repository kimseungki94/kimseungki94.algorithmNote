package inflearn.chap04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class chap4_4 {
    static HashMap<Character, Integer> hash = new HashMap<>();
    static HashMap<Character, Integer> memory = new HashMap<>();
    static char[] arr;
    static int N, M, count;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        N = text.length();
        arr = new char[N];
        for (int i = 0; i < N; i++) {
            arr[i] = text.charAt(i);
        }
        st = new StringTokenizer(br.readLine());
        text = st.nextToken();
        M = text.length();
        for (int i = 0; i < M; i++) {
            memory.put(text.charAt(i), memory.getOrDefault(text.charAt(i), 0) + 1);
        }
    }

    public void Solution() {
        int lt = 0;
        for (int i = 0; i < M - 1; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = M - 1; i < N; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
            if (hash.equals(memory)) count++;
            if (hash.get(arr[lt]) > 1) hash.put(arr[lt], hash.get(arr[lt]) - 1);
            else hash.remove(arr[lt]);
            lt++;
        }

    }

    public static void main(String[] args) throws Exception {
        chap4_4 main = new chap4_4();
        main.input();
        main.Solution();
        System.out.println(count);
    }
}
