package eCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chap09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String text = st.nextToken();
        String temp = "";
        int value = 0;
        for(char c : text.toCharArray()) {
            if(Character.isDigit(c)) {
                value+=c-'0';
            } else {
                temp+=c;
            }
        }
        char[] data = temp.toCharArray();
        Arrays.sort(data);
        for(char c : data) {
            sb.append(c);
        }
        sb.append(value);
        System.out.println(sb.toString());
    }
}
