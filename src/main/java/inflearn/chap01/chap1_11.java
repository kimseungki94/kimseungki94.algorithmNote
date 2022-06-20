package inflearn.chap01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chap1_11 {
    static int N;
    static String answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        int N = text.length();

        int count=1;
        answer="";
        answer+=text.charAt(0);
        for(int i=0;i<N-1;i++) {
            if(text.charAt(i)==text.charAt(i+1)) count++;
            else {
                if(count>1) answer+=String.valueOf(count);
                answer+=text.charAt(i+1);
                count=1;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        chap1_10 main = new chap1_10();
        main.input();
    }
}


