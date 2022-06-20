package inflearn.chap01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chap1_10 {
    static int N;
    static String answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        answer="";
        answer+=text.charAt(0);
        char key = text.charAt(0);
        int keyIndex = 0;
        for(int i=1;i<text.length();i++) {
            if(key==text.charAt(i)) {
            } else {
                if(i-keyIndex>1) {
                    answer+=i-keyIndex;
                }
                answer+=text.charAt(i);
                key = text.charAt(i);
                keyIndex=i;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        chap1_10 main = new chap1_10();
        main.input();
    }
}

