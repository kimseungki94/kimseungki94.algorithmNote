package inflearn.chap05;

import java.io.*;
import java.util.*;

public class chap5_7 {
    static int[] arr, select;
    static int[][] map;
    static int N, M, count;
    static String text, answer;
    static Queue<Character> queue = new LinkedList<>();
    static Queue<Character> essential = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        text=st.nextToken();
        for(char c : text.toCharArray()) {
            essential.offer(c);
        }
        st = new StringTokenizer(br.readLine());
        text=st.nextToken();
    }

    public String Solution() {
        answer="NO";
        for(char c : text.toCharArray()) {
            if(essential.contains(c)) {
                queue.offer(c);
            }
        }
        if(essential.equals(queue)){
            answer="YES";
        }
        return answer;
    }


    public static void main(String[] args) throws Exception {
        chap5_7 main = new chap5_7();
        main.input();
        System.out.println(main.Solution());
    }
}