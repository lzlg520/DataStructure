package com.lzlg.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PortlandExpressionDemo {
    public static void main(String[] args) {
        String expression = "10+(20+3)*4-(5*(6/2-1))";
        List<String> list = toList(expression);
        System.out.println("将表达式转换为list：" + list);
        // 1.中缀表达式转后缀表达式

        List<String> suffixList = toSuffixList(list);

        System.out.println("中缀表达式转后缀表达式list：" + suffixList);

        // 2.使用后缀表达式计算表达式结果

        int result = calculate(suffixList);

        System.out.println("使用后缀表达式计算出的结果为：" + result);
    }

    /**
     * 计算后缀表达式的结果
     *
     * @param suffixList
     * @return
     */
    private static int calculate(List<String> suffixList) {
        Stack<String> stack = new Stack<>();
        for (String item : suffixList) {
            if (item.matches("\\d+")) {
                stack.push(item);
            }

            if (isOperator(item)) {
                int result = getOpResult(stack.pop(), stack.pop(), item);
                stack.push(result + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 将中缀表达式转换为后缀表达式
     *
     * @param list
     * @return
     */
    private static List<String> toSuffixList(List<String> list) {
        // 符号栈
        Stack<String> signStack = new Stack<>();
        // 返回中缀表达式的结果
        List<String> result = new ArrayList<>();

        for (String item : list) {
            // 如果是数字直接加入
            if (item.matches("\\d+")) {
                result.add(item);
            }

            // 如果是左括号，直接入栈
            if (isLeftBracket(item)) {
                signStack.push(item);
            }
            // 如果是+,-,*,/; 比较优先级
            if (isOperator(item)) {
                while (!signStack.isEmpty() && comparePriority(signStack.peek(), item)) {
                    result.add(signStack.pop());
                }
                signStack.push(item);
            }
            // 如果是右括号，将直到左括号的符号全部弹出
            if (isRightBracket(item)) {
                while (!isLeftBracket(signStack.peek())) {
                    result.add(signStack.pop());
                }
                signStack.pop(); // 将最后的左括号弹出
            }
        }

        while (!signStack.isEmpty()) {
            result.add(signStack.pop());
        }
        return result;
    }

    /**
     * 将表达式转换成list
     * 10+(20+3)*4-(5*(6/2-1)) ==>> [10, +, (, 20, +, 3, ), *, 4, -, (, 5, *, (6, /, 2, -, 1, ), )]
     *
     * @param expression
     * @return
     */
    private static List<String> toList(String expression) {
        String[] split = expression.split("");
        List<String> list = new ArrayList<>();
        String str = "";
        for (String item : split) {
            if (isSign(item)) {
                if (!str.equals("")) {
                    list.add(str);
                    str = "";
                }
                list.add(item);
            }
            if (item.matches("\\d")) {
                str += item;
            }
        }
        return list;
    }

    private static boolean isLeftBracket(String s) {
        return s.equals("(");
    }

    private static boolean isRightBracket(String s) {
        return s.equals(")");
    }

    private static boolean isSign(String s) {
        return isOperator(s) || isLeftBracket(s) || isRightBracket(s);
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int getOpResult(String one, String two, String operator) {
        int x = Integer.parseInt(one);
        int y = Integer.parseInt(two);
        switch (operator) {
            case "+":
                return y + x;
            case "-":
                return y - x;
            case "*":
                return y * x;
            case "/":
                return y / x;
            default:
                return 0;
        }
    }

    /**
     * 比较两个操作符的优先级
     * 左边比右边高返回true，否则返回false
     *
     * @param leftOperator
     * @param rightOperator
     * @return
     */
    private static boolean comparePriority(String leftOperator, String rightOperator) {
        return Priority.getPriority(leftOperator) > Priority.getPriority(rightOperator);
    }

    static class Priority {
        private static int add = 1;

        private static int sub = 1;

        private static int mul = 2;

        private static int div = 2;

        public static int getPriority(String operator) {
            switch (operator) {
                case "+":
                    return add;
                case "-":
                    return sub;
                case "*":
                    return mul;
                case "/":
                    return div;
                default:
                    return 0;
            }
        }
    }
}

