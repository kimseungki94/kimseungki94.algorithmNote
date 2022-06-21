package inflearn.chap04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class chap4_4 {
    static HashMap<Integer, Integer> hash = new HashMap<>();
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<M-1;i++) {
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        int lt=0;
        for(int i=M-1;i<N;i++) {
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
            sb.append(hash.size()+" ");
            if(hash.get(arr[lt])>1) hash.put(arr[lt],hash.get(arr[lt])-1);
            else hash.remove(arr[lt]);
            lt++;
        }
        System.out.println(sb.toString());
    }
}
