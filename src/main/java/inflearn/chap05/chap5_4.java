package inflearn.chap05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class chap5_4 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count;
    static String text, answer;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Character> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        text = st.nextToken();
        list.add('+');
        list.add('-');
        list.add('/');
        list.add('*');
    }

    public int Solution() {
        for(char c : text.toCharArray()) {
            if(!Character.isDigit(c)){
                int a = stack.pop();
                int b = stack.pop();
                if(c=='+') stack.push(a+b);
                else if(c=='-') stack.push(b-a);
                else if(c=='*') stack.push(a*b);
                else if(c=='/') stack.push(b/a);
            } else {
                stack.push(c-'0');
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) throws Exception {
        chap5_4 main = new chap5_4();
        main.input();
        System.out.println(main.Solution());
    }
}
