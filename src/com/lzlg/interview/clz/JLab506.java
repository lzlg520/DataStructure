package com.lzlg.interview.clz;

public class JLab506 {
    public static void main(String[] args) {
        Shape t = new EqualTriangle("等边三角形", 8, 9);
        Shape c = new Circle("圆形", 15);
        Shape r = new Rectangular("长方形", 12, 10);

        System.out.println(t);
        System.out.println(c);
        System.out.println(r);
    }
}

abstract class Shape {
    String name;

    public Shape(String name) {
        this.name = name;
    }

    /**
     * 面积
     *
     * @return
     */
    abstract double area();

    /**
     * 周长
     *
     * @return
     */
    abstract double perimeter();

    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                '}';
    }
}

// 等边三角形
class EqualTriangle extends Shape {
    private double width;

    private double high;

    public EqualTriangle(String name, double width, double high) {
        super(name);
        this.width = width;
        this.high = high;
    }

    @Override
    double area() {
        return width * high / 2;
    }

    @Override
    double perimeter() {
        return 3 * width;
    }

    @Override
    public String toString() {
        return "EqualTriangle{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", high=" + high +
                '}';
    }
}

// 圆形
class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }
}

// 长方形
class Rectangular extends Shape {
    private double width;
    private double length;

    public Rectangular(String name, double width, double length) {
        super(name);
        this.width = width;
        this.length = length;
    }

    @Override
    double area() {
        return width * length;
    }

    @Override
    double perimeter() {
        return (width + length) * 2;
    }

    @Override
    public String toString() {
        return "Rectangular{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}