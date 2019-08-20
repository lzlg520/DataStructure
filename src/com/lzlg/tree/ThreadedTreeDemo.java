package com.lzlg.tree;

/**
 * 线索化二叉树：
 * 由于二叉树的叶子节点左右保留着空指针
 * 想利用这些left为null 和 right为null的节点。
 * 1.这些空指针节点的个数为 2n - (n - 1) 个，n为节点的数量
 * 2.线索化二叉树由于根据遍历的次序不同分为三类：
 * 前序线索化二叉树，中序线索化二叉树，后序线索化二叉树
 * 3.由于这样的方式
 * 一个节点的left和right节点会分为两种类型
 * 一种是子树类型，一种是节点类型
 */
public class ThreadedTreeDemo {
    public static void main(String[] args) {
        ThreadedNode root = new ThreadedNode(1, "a");
        ThreadedNode node2 = new ThreadedNode(3, "b");
        ThreadedNode node3 = new ThreadedNode(6, "c");
        ThreadedNode node4 = new ThreadedNode(8, "d");
        ThreadedNode node5 = new ThreadedNode(10, "e");
        ThreadedNode node6 = new ThreadedNode(14, "f");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedTree tree = new ThreadedTree(root);

        // 转化为中序线索化二叉树
        tree.toMiddleThreadedTree();
        // 验证
//        System.out.println(node5.getRight());
//        System.out.println(node5.getLeft());

        tree.threadedList();
    }
}

/**
 * 线索化二叉树
 */
class ThreadedTree {
    private ThreadedNode root;
    // 用来记录上一个节点
    private ThreadedNode pre;

    public ThreadedTree(ThreadedNode root) {
        this.root = root;
    }

    public void toMiddleThreadedTree() {
        toMiddleThreadedTree(root);
    }

    /**
     * 遍历线索化二叉树
     */
    public void threadedList() {
        ThreadedNode node = root;
        while (node != null) {
            // 找到左节点类型是Node的节点就是第一个要遍历的 id为8的节点
            while (node.getLeftType() == TreeTypeEnum.Tree) {
                node = node.getLeft();
            }
            // 将找到的第一个节点打印
            System.out.println(node);

            // 将当前节点的右节点类型为Node的节点打印
            while (node.getRightType() == TreeTypeEnum.Node) {
                node = node.getRight();
                System.out.println(node);
            }
            // 为了防止右节点类型不是Node类型造成的死循环
            node = node.getRight();
        }
    }

    /**
     * @param node 当前遍历的节点
     */
    private void toMiddleThreadedTree(ThreadedNode node) {
        if (node == null) {
            return;
        }
        // 左递归遍历左子树
        toMiddleThreadedTree(node.getLeft());

        // 设置节点
        // 1.设置节点的前驱节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(TreeTypeEnum.Node);
        }
        // 2.设置节点的后继节点
        if (pre != null && pre.getRight() == null) {
            // 注意此时 经过 pre = node 这一步
            // 上一个节点pre的右节点是当前节点
            pre.setRight(node);
            pre.setRightType(TreeTypeEnum.Node);
        }
        // !!! 这里很重要，必须有这一步
        pre = node; // 将当前节点作为下个要遍历的节点的前节点

        // 右递归右子树
        toMiddleThreadedTree(node.getRight());
    }
}

/**
 * 线索化节点
 */
class ThreadedNode {
    private int id;
    private String name;

    private ThreadedNode left;

    private ThreadedNode right;
    // 用来记录当前节点的前驱节点类型
    private TreeTypeEnum leftType = TreeTypeEnum.Tree;
    // 用来记录当前节点的后继节点类型
    private TreeTypeEnum rightType = TreeTypeEnum.Tree;

    public ThreadedNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThreadedNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadedNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedNode left) {
        this.left = left;
    }

    public ThreadedNode getRight() {
        return right;
    }

    public void setRight(ThreadedNode right) {
        this.right = right;
    }

    public TreeTypeEnum getLeftType() {
        return leftType;
    }

    public void setLeftType(TreeTypeEnum leftType) {
        this.leftType = leftType;
    }

    public TreeTypeEnum getRightType() {
        return rightType;
    }

    public void setRightType(TreeTypeEnum rightType) {
        this.rightType = rightType;
    }
}

enum TreeTypeEnum {
    Tree(0), Node(1);
    int value;

    TreeTypeEnum(int value) {
        this.value = value;
    }
}