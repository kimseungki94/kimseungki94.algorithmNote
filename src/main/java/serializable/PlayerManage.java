package serializable;

import java.io.*;

public class PlayerManage {
    static String path = File.separator+"Users"+File.separator+"kimseungki"+File.separator+"Documents"+ File.separator+"serializableTest"+File.separator+"test.bat";

    public static void write(PlayerDTO playerDTO) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(playerDTO);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PlayerDTO read() {
        PlayerDTO playerDTO;
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fi);
            playerDTO = (PlayerDTO) in.readObject();
            in.close();
            return playerDTO;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
