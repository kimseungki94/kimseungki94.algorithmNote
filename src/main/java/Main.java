import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    static int N, M, K, count, size, max, sum, min;
    static StringBuilder sb = new StringBuilder();
    static int[][] map, tempMap;
    static int[] arr;
    static boolean flag = false;
    static ArrayList<Integer> list = new ArrayList<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        countingSort();
    }

    private void countingSort() {
        arr = new int[]{5,1,2,3,8,4,2,5,7,9,0,3,1,6,2,4,8};
        int max = 0;
        for(int i=0;i<arr.length;i++) {
            max = Math.max(max,arr[i]);
        }
        int[] isSelected = new int[max+1];
        for(int i=0;i<arr.length;i++) {
            isSelected[arr[i]]++;
        }
        System.out.println(Arrays.toString(isSelected));
        for(int i=0;i<isSelected.length;i++) {
            while (isSelected[i]!=0) {
                isSelected[i]--;
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        System.out.println(Arrays.toString(arr));
    }
}
