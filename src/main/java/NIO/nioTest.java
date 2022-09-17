package NIO;

import serializable.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class nioTest {

    static String path = File.separator+"Users"+File.separator+"kimseungki"+File.separator+"Documents"+ File.separator+"serializableTest"+File.separator+"test.txt";

    public static void main(String[] args) {
        nioTest nioTest = new nioTest();
        try{
            nioTest.write(path,"Test NIO");
            nioTest.read(path);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void write(String fileName, String data) throws Exception {
        FileChannel channel = new FileOutputStream(fileName).getChannel();
        byte[] byteDate = data.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(byteDate);
        channel.write(buffer);
        channel.close();
    }

    public void read(String fileName) throws Exception {
        FileChannel channel = new FileInputStream(fileName).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            System.out.print((char)byteBuffer.get());
        }
    }
}
