package eCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap08 {
    static int[] nightY = new int[]{-2,-2,2,2,-1,1,-1,1}; // 상 하 좌 우
    static int[] nightX = new int[]{-1,1,-1,1,-2,-2,2,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        int row = text.charAt(0)-'a'+1;
        int col = text.charAt(1)-'0';
        int count=0;
        for(int i=0;i<8;i++) {
            int Y = row + nightY[i];
            int X = col + nightX[i];
            if(X>=1 && X<=8 && Y>=1 && Y<=8) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void nightMove() {

    }
}
