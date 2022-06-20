package inflearn.chap01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class chap1_7 {
    static int N;
    static String answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String text = br.readLine();
        int value =0;
        for(char c : text.toCharArray()) {
            if(Character.isDigit(c)) {
                value=value*10+Character.getNumericValue(c);
            }
        }
        System.out.println(value);
    }

    public static void main(String[] args) throws Exception {
        chap1_7 main = new chap1_7();
        main.input();
        System.out.println(answer);
    }


}


