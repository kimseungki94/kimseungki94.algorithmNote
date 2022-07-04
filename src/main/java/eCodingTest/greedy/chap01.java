package eCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[]{500,100,50,10};
        int money = 1280;
        int count=0;
        for(int i=0;i<arr.length;i++) {
            count+=money/arr[i];
            money%=arr[i];
        }
        System.out.println(count);
    }
}
