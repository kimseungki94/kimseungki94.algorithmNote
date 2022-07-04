package eCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count=0;
        if(N<M) {
            while (N!=1) {
                N--;
                count++;
            }
        } else {
            while (N/M!=1) {
                while (N%M!=0) {
                    N--;
                    count++;
                }
                N/=M;
                count++;
            }
            count++;
        }
        System.out.println(count);
    }
}
