package serializable;

import java.io.*;

public class HumanUtils{

    public static final String path= File.separator+"Users"+File.separator+"kimseungki"+File.separator+"Documents"+ File.separator+"serializableTest"+File.separator+"test.bat";

    public static void write (Human address) {

        try{
            FileOutputStream fout = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(address);
            oos.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static Human read () {

        Human address;
        try{
            FileInputStream fin = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fin);
            address = (Human) ois.readObject();
            ois.close();
            return address;

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}


