package com.lzlg.stack;

public class ExpressionCalculateDemo {
    public static void main(String[] args) {
        String expression = "70+20*6-500";
        int len = expression.length();

        CalculateStack numStack = new CalculateStack(10);

        CalculateStack operatorStack = new CalculateStack(10);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);

            if (CalculateUtil.isOperator(c)) {
                if (operatorStack.isEmpty()) {

                    operatorStack.push(c);

                } else {

                    if (CalculateUtil.getOperatorPriority(c) <= CalculateUtil.getOperatorPriority(operatorStack.peek())) {
                        int x = numStack.pop();
                        int y = numStack.pop();
                        int result = CalculateUtil.calculate(x, y, operatorStack.pop());
                        numStack.push(result);

                        operatorStack.push(c);
                    } else {
                        operatorStack.push(c);
                    }
                }

            } else {

                String s = c + "";
                sb.append(s);
                if (i < len - 1) {
                    if (!CalculateUtil.isOperator(expression.charAt(i + 1))) {
                        continue;
                    }
                }
                int number = Integer.parseInt(sb.toString());
                numStack.push(number);
                sb = new StringBuilder();
            }
        }


        while (!operatorStack.isEmpty()) {
            int x = numStack.pop();
            int y = numStack.pop();
            int r = CalculateUtil.calculate(x, y, operatorStack.pop());
            numStack.push(r);
        }
        int result = numStack.pop();
        System.out.printf("表达式：%s；最终的结果为：%d", expression, result);
    }
}

class CalculateStack {
    private int size;

    private int[] stack;

    private int top = -1;

    public CalculateStack(int size) {
        this.size = size;
        this.stack = new int[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int value) {
        if (isFull()) {
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return stack[top];
    }

    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.printf("static : index -> %d ; value -> %d", i, stack[i]);
        }
    }
}

class CalculateUtil {
    private CalculateUtil() {
    }

    public static boolean isOperator(int op) {
        if (op == '+' || op == '-' || op == '*' || op == '/') {
            return true;
        }
        return false;
    }

    public static int getOperatorPriority(int op) {
        if (op == '*' || op == '/') {
            return 1;
        } else if (op == '+' || op == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public static int calculate(int x, int y, int op) {
        switch (op) {
            case '+':
                return x + y;
            case '-':
                return y - x;
            case '*':
                return x * y;
            case '/':
                return y / x;
            default:
                return 0;
        }
    }
}