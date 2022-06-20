package inflearn.chap01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class chap1_6 {
    static int N;
    static String answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String text = br.readLine();
        text = text.toUpperCase().replaceAll("[^A-Z]","");
        System.out.println(Integer.parseInt(text));
        if(text.equalsIgnoreCase(new StringBuilder(text).reverse().toString())) {
            answer="YES";
        } else {
            answer="NO";
        }
    }

    public static void main(String[] args) throws Exception {
        chap1_6 main = new chap1_6();
        main.input();
        System.out.println(answer);
    }


}


