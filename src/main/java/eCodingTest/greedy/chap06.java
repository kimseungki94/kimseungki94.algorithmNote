package eCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap06 {
    static int[] dy = new int[]{-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dx = new int[]{0, 0, -1, 1};
    static String[] menu = new String[]{"U", "D", "L", "R"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), "");
        String[] data = st.nextToken().split(" ");
        int valueX = 1;
        int valueY = 1;
        for (int i = 0; i < data.length; i++) {
            int Y = 0;
            int X = 0;
            for(int j=0;j<4;j++) {
                if (data[i].equals(menu[j])) {
                    Y = valueY + dy[j];
                    X = valueX + dx[j];
                    break;
                }
            }
            if (X >= 1 && X <= N && Y >= 1 && Y <= N) {
                valueY = Y;
                valueX = X;
            }
        }
        System.out.println(valueY+" "+valueX);
    }
}
