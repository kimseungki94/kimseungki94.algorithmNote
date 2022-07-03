package programmers_develop_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class develop_02_02 {

    static int N, M, max;
    static int[] arr, dp;
    static boolean isSelected;
    static String target;
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=1;
        boolean horizontal=false;
        int n=5;
        int[][] answer = new int[n][n];
        answer[0][0]=1;
        if(horizontal) {
            for(int index=1;index<n;index++) {
                if(index%2==1) {
                    answer[0][index]=++count;
                    for(int row=2;row<=index;row++) {
                        answer[row][index]=++count;
                    }
                    for(int col=index-1;col>=1;col--) {
                        answer[index][col]=++count;
                    }
                } else {
                    answer[index][0]=++count;
                    for(int col=2;col<=index;col++) {
                        answer[index][col]=++count;
                    }
                    for(int row=index-1;row>=1;row--) {
                        answer[row][index]=++count;
                    }
                }
            }
        } else {
            for(int index=1;index<n;index++) {
                if(index%2==1) {
                    answer[index][0]=++count;
                    for(int col=1;col<=index;col++) {
                        answer[index][col]=++count;
                    }
                    for(int row=index-1;row>=0;row--) {
                        answer[row][index]=++count;
                    }
                } else {
                    answer[0][index]=++count;
                    for(int row=2;row<=index;row++) {
                        answer[row][index]=++count;
                    }
                    for(int col=index-1;col>=0;col--) {
                        answer[index][col]=++count;
                    }

                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }

    public static void main(String[] args) throws Exception {
        develop_02_02 main = new develop_02_02();
        main.input();
    }
}

