package com.lzlg.interview;

public class ExtendQuestionTest {
    public static void main(String[] args) {
        Student student = new Student(16);
        System.out.println(student.getName());
    }
}

class Person {
    String name = "no name";

    public Person() {
        name = "a person";
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    public Student(int age) {
        // 此时注意 name 不过是构造方法里的局部变量
        String name = "a student";
    }
}

interface D {
}

class A {
}

class B extends A implements D {
}

class C extends B {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        if (a instanceof B)
            System.out.println("Hello vivi");
        if (b instanceof A)
            System.out.println("Hello cici");
        if (c instanceof C)
            System.out.println("Hello wiwi");
        if (c instanceof D) {
            System.out.println("Hello");
        }
    }
}