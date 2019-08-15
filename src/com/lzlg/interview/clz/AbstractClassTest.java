package com.lzlg.interview.clz;

/**
 * 抽象类规则：
 * 只有返回值类型，方法名，方法参数而没有方法体的方法就是抽象方法
 * 抽象类和抽象方法必须用abstract来修饰
 * 不能用abstract修饰构造函数，静态方法，和private方法
 */
public class AbstractClassTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(23, 2);
        Trapezoidal trapezoidal = new Trapezoidal(12, 34, 2);
        triangle.setName("三角形的面积");
        trapezoidal.setName("梯形的面积");
        System.out.println(triangle.getName() + " " + triangle.area());
        System.out.println(trapezoidal.getName() + " " + trapezoidal.area());
    }
}

/**
 * 抽象方法是否可同时为static，是否可同时为native，是否可同时为synchronized方法？
 * 都不可以
 * 1.abstract方法是用来给子类实现的，如果方法为static，不能表现出多态
 * 2.native方法是通过引入其他语言的来实现的，而在static块或方法里，无法引入不同的语言的实现
 * 3.synchronized 同步的是同一对象，而不是不同实现的不同对象
 */
// 抽象类：几何形状
abstract class Type {
    double height, width, length;
    String name;

    abstract double area();

    abstract String getName();

    public Type(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public Type(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 三角形
class Triangle extends Type {
    public Triangle(double height, double width) {
        super(height, width);
    }

    @Override
    double area() {
        return height * width / 2;
    }

    @Override
    String getName() {
        return name;
    }
}

// 梯形
class Trapezoidal extends Type {
    public Trapezoidal(double height, double width, double length) {
        super(height, width, length);
    }

    @Override
    double area() {
        return (height + width) * length / 2;
    }

    @Override
    String getName() {
        return name;
    }
}
