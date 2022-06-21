package inflearn.chap04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class chap4_1 {
    static HashMap<Character,Integer> hash = new HashMap<>();
    static int N,max;
    static String text;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        text = st.nextToken();
        for(char c : text.toCharArray()) {
            hash.put(c,hash.getOrDefault(c,0)+1);
        }
        char value = 0;
        for(char c : hash.keySet()) {
            if(max<hash.get(c)) {
                max=hash.get(c);
                value=c;
            }
        }
        System.out.println(value);
    }
}
