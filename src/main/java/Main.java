
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
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
        for(int i=0;i<N;i++) {
            String temp = text.substring(0,7);
            text = text.substring(7);
            System.out.print((char)Integer.parseInt(temp,2));
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
    }
}

