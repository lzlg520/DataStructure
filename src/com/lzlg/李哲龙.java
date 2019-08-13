package com.lzlg;

public class 李哲龙 {
    private String 性别;

    private String 年龄;

    private String 生日;

    public 李哲龙(String 性别, String 年龄, String 生日) {
        this.性别 = 性别;
        this.年龄 = 年龄;
        this.生日 = 生日;
    }

    public String get性别() {
        return 性别;
    }

    public void set性别(String 性别) {
        this.性别 = 性别;
    }

    public String get年龄() {
        return 年龄;
    }

    public void set年龄(String 年龄) {
        this.年龄 = 年龄;
    }

    public String get生日() {
        return 生日;
    }

    public void set生日(String 生日) {
        this.生日 = 生日;
    }

    @Override
    public String toString() {
        return "李哲龙{" +
                "性别='" + 性别 + '\'' +
                ", 年龄='" + 年龄 + '\'' +
                ", 生日='" + 生日 + '\'' +
                '}';
    }

    public static void main(String[] args) {
        李哲龙 lzlg = new 李哲龙("男", "29", "08-21");
        System.out.println(lzlg);
    }
}
