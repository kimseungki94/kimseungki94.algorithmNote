package eCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int count = 0;
        for (int i = 0; i <= N; i++) {
            for (int minute = 0; minute <= 59; minute++) {
                for (int second = 0; second <= 59; second++) {
                    if (i % 10 == 3 || i / 10 == 3 || minute % 10 == 3 || minute / 10 == 3 || second % 10 == 3 || second / 10 == 3) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
