package com.lzlg.tree;

/**
 * 顺序存储二叉树：
 * 将数组转化为二叉树，并满足以下规则：
 * 1.该二叉树通常是完全二叉树（即没有叶节点的缺失）
 * 2.二叉树的节点（数组元素下标为n）的 左节点 的数组下标为 2 * n + 1
 * 3.二叉树的节点（数组元素下标为n）的 右节点 的数组下标为 2 * n + 2
 * 4.二叉树的节点（数组元素下标为n）的父节点的数组下标为 (n - 1) / 2
 */
public class ArrayOrderTreeDemo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        // 数组下标为0的元素为根元素

        ArrayOrderTree tree = new ArrayOrderTree(array);
        System.out.println("前序遍历：");
        tree.preList();
        System.out.println("中序遍历：");
        tree.midList();
        System.out.println("后序遍历：");
        tree.postList();
    }
}

class ArrayOrderTree {
    int[] array;

    public ArrayOrderTree(int[] array) {
        this.array = array;
    }

    public void preList() {
        if (array == null || array.length == 0) {
            System.out.println("数组为空，没有元素可以遍历");
            return;
        }
        preList(0);
    }

    /**
     * 前序遍历
     *
     * @param index 要遍历的节点的数组下标
     */
    private void preList(int index) {
        System.out.println(array[index]);
        // 左递归遍历
        if ((index * 2 + 1) < array.length) {
            preList(index * 2 + 1);
        }
        // 右递归遍历
        if ((index * 2 + 2) < array.length) {
            preList(index * 2 + 2);
        }
    }

    public void midList() {
        if (array == null || array.length == 0) {
            System.out.println("数组为空，没有元素可以遍历");
            return;
        }
        midList(0);
    }

    private void midList(int index) {
        // 左递归遍历
        if ((index * 2 + 1) < array.length) {
            midList(index * 2 + 1);
        }

        System.out.println(array[index]);

        // 右递归遍历
        if ((index * 2 + 2) < array.length) {
            midList(index * 2 + 2);
        }
    }

    public void postList() {
        if (array == null || array.length == 0) {
            System.out.println("数组为空，没有元素可以遍历");
            return;
        }

        postList(0);
    }

    private void postList(int index) {
        // 左递归遍历
        if ((index * 2 + 1) < array.length) {
            postList(index * 2 + 1);
        }

        // 右递归遍历
        if ((index * 2 + 2) < array.length) {
            postList(index * 2 + 2);
        }

        System.out.println(array[index]);
    }
}