package com.lzlg.interview;


public class ExceptionTest {
    /**
     * 常见的运行时异常：
     * ArithmeticException : 算术异常
     * ArrayIndexOutOfBoundsException : 数组下标越界
     * ArrayStoreException : 数组元素值与数组类型不同
     * ClassCastException : 强制类型转换异常，类型不匹配
     * IllegalArgumentException : 非法参数异常
     * IllegalMonitorStateException : 非法监控操作
     * IllegalStateException : 环境或状态异常
     * IllegalThreadStateException : 请求操作和当前线程不兼容
     * IndexOutOfBoundsException : 索引越界
     * NullPointerException : 空指针异常
     * NumberFormatException : 数字转换异常
     * SecurityException : 安全性异常
     * StringIndexOutOfBoundsException : 字符串索引越界异常
     * UnsupportedOperationException : 操作错误异常
     * <p>
     * 场景的检查型异常：
     * ClassNotFoundException : 找不到相关类异常
     * CloneNotSupportedException : 对象不能实现克隆异常
     * IllegalAccessException : 非法访问异常
     * InstantiationException : 创建抽象对象
     * NoSuchFieldException : 请求的字段属性不存在
     * NoSuchMethodException : 请求的方法不存在
     * IOException : IO操作异常
     */
    public static void main(String[] args) {
//        RuntimeException re = NullPointerException;
//        throw re;

        try {
            System.out.println("Only try, no have catch");
            throwDo();
            System.out.println("After throwDo then print");
        } finally {
            System.out.println("finally executing");
        }

        System.gc();

    }

//    private static final RuntimeException NullPointerException = null;

    private static void throwDo() {
        throw new ArithmeticException();
    }
}
