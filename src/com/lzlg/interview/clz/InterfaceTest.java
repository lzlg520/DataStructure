package com.lzlg.interview.clz;

import java.io.IOException;

public class InterfaceTest {
}

/**
 * 接口和抽象类的区别
 * <p>
 * 接口：
 * 1.接口没有构造函数
 * 2.接口中的变量均为 public static final
 * 3.接口中定义的方法全是公共抽象方法(Java8加入了静态方法和默认方法)
 * 4.接口里的变量必须初始化，并且都为常量
 * 5.接口可以多继承
 * <p>
 * 抽象类：
 * 1.抽象类和抽象方法必须用 abstract 关键字修饰
 * 2.抽象类不能被实例化
 * 3.抽象方法只需声明，无需实现
 * 4.抽象方法必须定义在抽象类中，抽象类的子类(非抽象类)必须实现父类中的抽象方法
 * 5.抽象类只能单继承
 */
interface Truck {
    void sound() throws IOException;
}

interface Bus {
    void sound() throws Exception;
}

/**
 * 接口方法名同名：
 * 1.如果两个接口有同名的方法，但是返回值不同，一个类不能同时实现该两个接口
 * 2.两个接口的同名方法声明抛出的异常，在实现类中抛出的异常是这两个异常的交集
 */
class Car implements Truck, Bus {
//    @Override
//    public void sound() throws Exception {
//
//    }


    @Override
    public void sound() throws IOException {

    }
}