package com.lzlg.tree;

/**
 * 二叉树
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "吴用");
        HeroNode node2 = new HeroNode(3, "卢俊义");
        HeroNode node3 = new HeroNode(4, "林冲");

        BinaryTree tree = new BinaryTree(root);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);

//        tree.preList();
//        tree.midList();
        tree.postList();

    }

}

/**
 * 二叉树
 */
class BinaryTree {
    private HeroNode root; // 二叉树根节点

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    /**
     * 树的遍历方式：
     * 1.前序遍历，中节点-->左节点-->右节点
     * 2.中序遍历，左节点-->中节点-->右节点
     * 3.后序遍历，左节点-->右节点-->中节点
     * 规律：根据遍历的中节点确定遍历的方式
     */
    public void preList() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("Empty tree!");
        }
    }

    public void midList() {
        if (root != null) {
            root.midOrder();
        } else {
            System.out.println("Empty tree!");
        }
    }

    public void postList() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("Empty tree!");
        }
    }
}

/**
 * 树结构--节点
 */
class HeroNode {
    private int id;

    private String name;

    private HeroNode left; // 左节点

    private HeroNode right; // 右节点

    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.midOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}