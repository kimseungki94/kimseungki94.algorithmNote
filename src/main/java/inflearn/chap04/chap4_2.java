package inflearn.chap04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class chap4_2 {
    static HashMap<Character,Integer> hash1 = new HashMap<>();
    static HashMap<Character,Integer> hash2 = new HashMap<>();
    static int N,max;
    static String text;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        text = st.nextToken();
        for(char c : text.toCharArray()) {
            hash1.put(c,hash1.getOrDefault(c,0)+1);
        }
        st = new StringTokenizer(br.readLine());
        text = st.nextToken();
        for(char c : text.toCharArray()) {
            hash2.put(c,hash2.getOrDefault(c,0)+1);
        }
        String answer = "YES";
        for(char c : hash1.keySet()) {
            if(hash1.get(c)!=hash2.get(c)) {
                answer="NO";
                break;
            }
        }
        System.out.println(answer);
    }
}
