package com.liuy307.j2se.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IoDemo {
    //字符的Unicode形式，即内存中字符的存在方式。
    @Test
    public void string2Unicode() {
        String str = "It's 知乎日报";
        StringBuffer unicode = new StringBuffer();
        char[] chs = str.toCharArray();
        for(char c:chs) {
            int i = c;
            System.out.println(c);
            System.out.println(i);
            System.out.println(Integer.toBinaryString(i));
            unicode.append("\\u" + Integer.toHexString(c));
        }
        System.out.println(unicode);
    }

    //字符的各种形式编码。字符在内存外（磁盘、网络中）以utf-8、gbk等形式表示
    @Test
    public void String2Code() throws UnsupportedEncodingException {
        String s = "It's 知乎日报";
        byte[] bts = s.getBytes("utf-8");//将Unicode用utf-8实现
        for(byte b:bts) {
            //System.out.println(b);
            System.out.println(Integer.toBinaryString(0x000000FF & b));//打印
        }
        byte[] bts2 = s.getBytes("gbk");//将Unicode用utf-8实现
        for(byte b:bts2) {
            //System.out.println(b);
            System.out.println(Integer.toBinaryString(0x000000FF & b));//int会在byte前补符号位111
        }
    }

    //InputStream以字节形式读入流，test.txt为utf-8编码方式，test2.txt为gbk编码方式,read()
    @Test
    public void getCodeFromFile() throws IOException {
        //        InputStream is = new FileInputStream("D:\\test2.txt");
        try (InputStream is = new FileInputStream("D:\\test.txt")) {
            int n;
            while((n=is.read()) != -1) {
                System.out.println(Integer.toBinaryString(n));
            }
        }//以utf-8形式保存
    }

    //InputStream以字节形式读入流，test.txt为utf-8编码方式，test2.txt为gbk编码方式,read(byte[])
    @Test
    public void getCodeFromFile2() throws IOException {
        byte[] buffer = new byte[30];
        try (InputStream is = new FileInputStream("D:\\test.txt")) {
            int n;  //read(buffer)返回为读取了多少字节数据
            while((n=is.read(buffer)) != -1) {
                System.out.println("read " + n + " bytes.");
            }
        }//以utf-8形式保存
        for(byte b:buffer) {
            System.out.println(b);
//            System.out.println(Integer.toBinaryString(0x000000FF & b));//打印
        }
    }

    //ByteArrayInputStream可以模拟数据流,会乱码，汉字不能用read转换
    @Test
    public void getChar() throws IOException {
        byte[] data = { 105, 116, 39, 115, 32, -25, -97, -91, -28, -71, -114, -26, -105, -91, -26, -118, -91};
        StringBuilder sb = new StringBuilder();
        try (InputStream input = new ByteArrayInputStream(data)) {
            int n;
            while ((n = input.read()) != -1) {
                sb.append((char)n);
                System.out.println((char)n);
            }
        }
        System.out.println(sb);
    }

    //OutputStream将utf-8编码写到文件
    @Test
    public void writeByte() throws IOException {
        byte[] data = { 105, 116, 39, 115, 32, -25, -97, -91, -28, -71, -114, -26, -105, -91, -26, -118, -91};
        try (OutputStream os = new FileOutputStream("D:\\test3.txt")) {
            os.write(data); //writ(int i)方法输入int,但实际只截取后8位，即& 0x000000FF
        }
    }

    //Reader, StandardCharsets.UTF_8
    @Test
    public void readFile() throws IOException {
        try (Reader reader = new FileReader("D:\\test.txt")){
            int n;
            while((n =reader.read())!=-1) {
                System.out.println((char) n);
            }
        }
    }

    @Test
    public void readFile2() throws IOException {
        try (Reader reader = new FileReader("D:\\test.txt")){
            char[] buffer = new char[30];
            int n;
            while((n =reader.read(buffer))!=-1) {
                System.out.println(n);
            }
//            System.out.println(buffer.toString());
            System.out.println(new String(buffer));
        }

    }

}
