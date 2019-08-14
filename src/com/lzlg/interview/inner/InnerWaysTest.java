package com.lzlg.interview.inner;

public class InnerWaysTest {
    public static void main(String[] args) {
        User u = new User();
        u.user("王五");
    }
}

class User {
    String name = "张三";

    void user(final String name) {
        final int score = 98;
        class Inner {
            void print() {
                System.out.println(name + " 成绩：score = " + score);
            }
        }
        Inner inner = new Inner();
        inner.print();
    }
}