package exception.checkedExceptionTryCatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class End {
    public void inputEnd() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        try {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }
}
