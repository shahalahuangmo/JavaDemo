package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-08 16:13
 */
public class Test {
    static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws Exception {


    }

    public  static  void NIOFile() throws  Exception{
        File file = new File("D:\\StudyBook\\2020王道数据结构.pdf");
        FileInputStream in = new FileInputStream(file);
        FileChannel channel = in.getChannel();
        MappedByteBuffer buff = channel.map(FileChannel.MapMode.READ_ONLY, 0,
                channel.size());

        byte[] b = new byte[1024];
        int len = (int) file.length();

        long begin = System.currentTimeMillis();
        for (int offset = 0; offset < len; offset += 1024) {

            if (len - offset > BUFFER_SIZE) {
                buff.get(b);
            } else {
                buff.get(new byte[len - offset]);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("nio time is:" + (end - begin));
    }

    public  static  void IOFile() throws  Exception{
        File file = new File("D:\\StudyBook\\2020王道数据结构.pdf");
        FileInputStream in = new FileInputStream(file);
        FileChannel channel = in.getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);

        long begin = System.currentTimeMillis();
        while (channel.read(buff) != -1) {
            buff.flip();
            buff.clear();
        }
        long end = System.currentTimeMillis();
        System.out.println("io time is:" + (end - begin));
    }
}
