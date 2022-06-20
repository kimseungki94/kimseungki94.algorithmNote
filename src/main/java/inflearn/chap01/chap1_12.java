package inflearn.chap01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap1_12 {
    static int N;
    static String answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        text = text.replace('#','1').replace('*','0');
        while (text.length()>0) {
            String temp = text.substring(0,7);
            if(!text.contains("1") || !temp.contains("0")) break;
            else text = text.substring(7);
            System.out.print((char)Integer.parseInt(temp,2));
        }
    }

    public static void main(String[] args) throws Exception {
        chap1_12 main = new chap1_12();
        main.input();
    }
}


