package com.lzlg.interview.inner;

public class OuterClassTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.print();
    }
}

class Outer {
    String name = "在类中创建一个内部类";

    void print() {
        Talk talk = new Talk();
        talk.talk();
    }

    public class Talk {
        void talk() {
            System.out.println(name);
        }
    }
}