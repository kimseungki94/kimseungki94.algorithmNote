package inflearn.chap05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap5_5 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count;
    static String text, answer;
    static Stack<Character> stack = new Stack<>();
    static ArrayList<Character> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        text = st.nextToken();
    }

    public int Solution() {
        char memory = 0;
        for(char c : text.toCharArray()) {
            if(c==')') {
                stack.pop();
                if(memory==')') {
                    count++;
                } else {
                    count+=stack.size();
                }
            } else {
                stack.push(c);
            }
            memory=c;
        }
        return count;
    }


    public static void main(String[] args) throws Exception {
        chap5_5 main = new chap5_5();
        main.input();
        System.out.println(main.Solution());
    }
}
