package serializable;

import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        PlayerDTO player1 = new PlayerDTO("kim",170,"ST");
        PlayerDTO player2 = new PlayerDTO("lee",180,"LF");
        PlayerDTO player3 = new PlayerDTO("park",175,"LB");

        PlayerManage.write(player1);
        PlayerDTO playerDTO = PlayerManage.read();
        sb.append(playerDTO).append("\n");

        System.out.println(sb.toString());
    }
}
