package eCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        int value=text.charAt(0)-'0';

        for(int i=1;i<text.length();i++) {
            if(text.charAt(i-1)=='0' || text.charAt(i-1)=='1') {
                value+=text.charAt(i)-'0';
            } else {
                value*=text.charAt(i)-'0';
            }
        }
        System.out.println(value);
    }
}
