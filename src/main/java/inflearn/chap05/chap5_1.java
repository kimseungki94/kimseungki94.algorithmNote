package inflearn.chap05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap5_1 {
    static int[] arr;
    static int N, M, count;
    static String text, answer;
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        text = st.nextToken();
    }

    public String Solution() {
        answer = "YES";
        for (char c : text.toCharArray()) {
            if (c == '(') stack.push('(');
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) throws Exception {
        chap5_1 main = new chap5_1();
        main.input();
        System.out.println(main.Solution());
    }
}
