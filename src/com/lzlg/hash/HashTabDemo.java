package com.lzlg.hash;

import java.util.Scanner;

/**
 * 哈希表实现
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add(a) : 添加");
            System.out.println("find(f) : 查找");
            System.out.println("list(l) : 显示");
            System.out.println("exit(e) : 退出");
            String input = scanner.next();
            switch (input) {
                case "a":
                    System.out.println("请输入id:");
                    int id = scanner.nextInt();
                    System.out.println("请输入name:");
                    String name = scanner.next();
                    hashTab.add(new Employee(id, name));
                    break;
                case "f":
                    System.out.println("请输入id:");
                    id = scanner.nextInt();
                    hashTab.find(id);
                    break;
                case "l":
                    hashTab.list();
                    break;
                case "e":
                    scanner.close();
                    System.exit(0);
            }
        }

    }
}

class HashTab {
    EmployeeList[] employeeListArray;// 存储链表的数组
    int size;

    public HashTab(int size) {
        this.size = size;
        employeeListArray = new EmployeeList[size];
        for (int i = 0; i < size; i++) {
            employeeListArray[i] = new EmployeeList();
        }
    }

    public void add(Employee employee) {
        int id = employee.id;
        int hash = hash(id);
        employeeListArray[hash].add(employee);
    }

    public void find(int id) {
        int hash = hash(id);
        Employee employee = employeeListArray[hash].find(id);
        if (employee == null) {
            System.out.println("没有找到");
        } else {
            System.out.printf("在第%d条链表中找到：Employee : id = %d, name = %s;\n",
                    hash + 1, employee.id, employee.name);
        }
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            employeeListArray[i].list(i);
        }
    }

    // hash方法
    public int hash(int id) {
        return id % size;
    }
}

/**
 * 雇员链表
 */
class EmployeeList {
    Employee head; // 链表头部元素

    /**
     * 添加一个新雇员到链表中
     *
     * @param employee
     */
    public void add(Employee employee) {
        if (head == null) { // 先添加头部元素
            head = employee;
            return;
        }
        Employee temp = head;
        while (true) {
            if (temp.next == null) {// 找到链表的最后
                break;
            }
            temp = temp.next; // 没找到向后移动
        }
        temp.next = employee;
    }

    public Employee find(int id) {
        if (head == null) {
            return null;
        }
        Employee temp = head;
        while (true) {
            if (temp.id == id) {
                return temp;
            }

            if (temp.next == null) {
                return null;
            }

            temp = temp.next;
        }
    }

    public void list(int no) {
        if (head == null) { // 链表为空，直接返回
            System.out.println("第" + (no + 1) + "链表为空");
            return;
        }
        System.out.print("第" + (no + 1) + "链表遍历：");
        Employee temp = head;
        while (true) {
            System.out.print("Employee : id = " + temp.id + "; name = " + temp.name);
            if (temp.next == null) {// 到链表的最后
                break;
            }
            temp = temp.next; // 没找到向后移动
        }
        System.out.println();
    }
}

/**
 * 雇员
 */
class Employee {
    int id;
    String name;

    Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}