package inflearn.chap04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap4_5 {
    static HashMap<Character, Integer> hash = new HashMap<>();
    static HashMap<Character, Integer> memory = new HashMap<>();
    static int[] arr;
    static int N, M, count, answer;
    static StringBuilder sb = new StringBuilder();
    static TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void Solution() {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    treeSet.add(sum);
                    count++;
                }
            }
        }
        System.out.println(count);
        count = 0;
        answer = -1;
        int index = 1;
        for (int value : treeSet) {
            if (index == M) {
                answer = value;
            }
            index++;
        }
    }

    public void DFS(int index, int limit, int value) {
        if (limit == M) {
            treeSet.add(value);
        } else {
            count++;
            if(index<N) {
                DFS(index + 1, limit + 1, value + arr[index]);
                DFS(index + 1, limit, value);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        chap4_5 main = new chap4_5();
        main.input();
        main.Solution();
        main.DFS(0, 0, 0);
        System.out.println(count);
        System.out.println(answer);
    }
}

