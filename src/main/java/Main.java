import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int max=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        int min=0;
        int lt = min;
        int rt = max;
        System.out.println(lt+" "+rt);
        while (lt<=rt) {
            System.out.println(lt + " "+rt);
            int mid = (lt+rt)/2;
            int value=0;
            for(int i=0;i<N;i++) {
                if(arr[i]>mid) value+=arr[i]-mid;
            }
            if(value==M) {
                System.out.println(value);
                break;
            } else if(value<M) {
                rt = mid-1;
            } else {
                lt = mid+1;
            }
        }
    }
}