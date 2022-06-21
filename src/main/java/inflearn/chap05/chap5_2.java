package inflearn.chap05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap5_2 {
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
        answer = "";
        for (char c : text.toCharArray()) {
            if(c==')') {
                while (stack.pop()!='(');
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()) return "";
        for(int i=0;i<stack.size();i++) {
            answer+=stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        chap5_2 main = new chap5_2();
        main.input();
        System.out.println(main.Solution());
    }
}
