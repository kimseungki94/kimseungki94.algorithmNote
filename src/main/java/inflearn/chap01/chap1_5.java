package inflearn.chap01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap1_5 {
    static int N;
    static String answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        char[] arr = new char[text.length()];
        for(int i=0;i<text.length();i++) {
            arr[i] = text.charAt(i);
        }
        answer="";
        int lt,rt;
        lt=0;
        rt=text.length()-1;
        while (lt<rt) {
            if(!Character.isAlphabetic(arr[lt])) lt++;
            else if(!Character.isAlphabetic(arr[rt])) rt--;
            else {
                char tmp = arr[rt];
                arr[rt]=arr[lt];
                arr[lt]=tmp;
                lt++;
                rt--;
            }
        }

        for(int i=0;i<text.length();i++) {
            sb.append(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        chap1_5 main = new chap1_5();
        main.input();
        System.out.println(sb.toString());
    }
}


