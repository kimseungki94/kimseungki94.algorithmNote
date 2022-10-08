package caesar;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String path = File.separator+"Users"+File.separator+"kimseungki"+File.separator+"Documents"+ File.separator+"serializableTest"+File.separator+"test.txt";

    public static void main(String[] args) throws Exception {
        read(path);
        String data = Solution(sb.toString(),25);
        System.out.println(data);
        data = antiSolution(data,25);
        System.out.println(data);

    }

    public static String Solution(String s, int n) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < s.length(); j++){
                if(arr[j] == ' ') continue;
                else if(arr[j] == 'z' || arr[j] == 'Z') arr[j] -= 26;
                arr[j] += 1;
            }
        }

        String answer = new String(arr);
        return answer;
    }

    public static String antiSolution(String s, int n) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < s.length(); j++){
                if(arr[j] == ' ') continue;
                else if(arr[j] == 'a' || arr[j] == 'A') arr[j] += 26;
                arr[j] -= 1;
            }
        }

        String answer = new String(arr);
        return answer;
    }

    public static void read(String fileName) throws Exception {
        FileChannel channel = new FileInputStream(fileName).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            char c = (char)byteBuffer.get();
            sb.append(c);
        }
    }
}
