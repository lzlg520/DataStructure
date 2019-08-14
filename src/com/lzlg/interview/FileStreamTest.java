package com.lzlg.interview;

import java.io.*;

public class FileStreamTest {
    public static void main(String[] args) throws Exception {
//        inOutTest();

//        fileWriterAndReader();

//        bufferedWriterAndReader();

        readFile();
    }

    private static void readFile() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\tt", "bb.txt")));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println("Read : " + s);
        }
        reader.close();
    }

    private static void bufferedWriterAndReader() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("D:\\tt", "bb.txt")));

        String input;
        System.out.println("请输入字符串，以end结束！");
        while (!(input = bufferedReader.readLine()).equals("end")) {
            bufferedWriter.write(input);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void fileWriterAndReader() throws Exception {
        System.out.print("请输入留言！按回车结束：");
        InputStreamReader in = new InputStreamReader(System.in);

        File file = new File("D:\\tt", "test.txt");
        FileWriter fileWriter = new FileWriter(file);

        int c;
        while ((c = in.read()) != '\n') {
            fileWriter.write(c);
        }
        in.close();
        fileWriter.close();

        FileReader fileReader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        int read = fileReader.read(chars);
        for (int i = 0; i < read; i++) {
            System.out.print(chars[i]);
        }
        fileReader.close();

    }

    private static void inOutTest() throws Exception {
        InputStreamReader in = new InputStreamReader(System.in);
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        int c;
        System.out.print("请输入一行字符，并按回车结束：");
        while ((c = in.read()) != '\n') {
            out.write(c);
        }
        out.close();
        in.close();
    }

    private static void copyFile() throws Exception {
        File f = new File("D:\\tt", "NameClass.java");
        FileInputStream fis = new FileInputStream(f);
        byte[] bytes = new byte[(int) f.length()];
        int read = fis.read(bytes);

        System.out.println(read);

        File file = new File("D:\\tt", "CopyNameClass.java");
        boolean newFile = file.createNewFile();
        if (newFile) {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
        }
        fis.close();
    }
}
