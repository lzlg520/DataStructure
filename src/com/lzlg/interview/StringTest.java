package com.lzlg.interview;

public class StringTest {
    public static void main(String[] args) {
        String string = new String();
        System.out.println(string); // 空串

        stringBufferTest();

    }

    private static void stringBufferTest() {
        // append方法
        StringBuffer appendBuffer = new StringBuffer("StringBuffer ");
        appendBuffer.append("sb ");
        appendBuffer.append("= ");
        appendBuffer.append("new ");
        appendBuffer.append("StringBuffer(");
        appendBuffer.append("1026)");
        System.out.println(appendBuffer);

        // insert方法
        StringBuffer insertBuffer = new StringBuffer("Hello Kitty");
        insertBuffer.insert(5, " ****");
        System.out.println(insertBuffer);

        // delete方法
        StringBuffer deleteBuffer = new StringBuffer("Hello 123 Kitty");
        deleteBuffer.delete(6, 9);
        System.out.println(deleteBuffer);

        // reverse方法
        StringBuffer reverseBuffer = new StringBuffer("123456789");
        reverseBuffer.reverse();
        System.out.println(reverseBuffer);
        // 设置字符序列的长度，将原来的字符序列长度改为5
        reverseBuffer.setLength(5);
        System.out.println(reverseBuffer);
    }
}
