package inflearn.chap01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class chap1_3 {
    static String answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int index=0;
        int min = Integer.MIN_VALUE;
        while ((index=text.indexOf(" "))!=-1) {
            String temp = text.substring(0,index);
            if(min<temp.length()) {
                min = temp.length();
                answer=temp;
            }
            text = text.substring(index+1);
        }
        if(text.length()>min) answer=text;
    }

    public static void main(String[] args) throws Exception {
        chap1_3 main = new chap1_3();
        main.input();
        System.out.println(answer);
    }
}


