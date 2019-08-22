package com.lzlg.tree;

/**
 * 平衡二叉树，是在二叉排序树上的一次优化
 * 1.什么是平衡二叉树？
 * 一个树的左子树和右子树高度之差不大于1的二叉树是平衡二叉树
 * 平衡二叉树提高了二叉排序树的查询效率
 * <p>
 * 2.左旋转
 * 如果二叉排序树的 (右子树高度 - 左子树高度 > 1) 则树需要左旋
 * <p>
 * 3.右旋转
 * 如果二叉排序树的 (左子树高度 - 右子树高度 > 1) 则树需要右旋
 * <p>
 * 4.双旋转
 * 如果二叉排序树根节点的 (右子树高度 - 左子树高度 > 1) 则树需要左旋
 * 根节点的左子树的 左子树高度 大于 右子树高度 则需要右旋
 * （如果不右旋，则上步形成的二叉树仍然不是平衡二叉树）
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        // 左旋示例数组
        int[] leftRotateArray = {4, 3, 6, 5, 7, 8};
        // 右旋示例数组
        int[] rightRotateArray = {10, 12, 8, 9, 7, 6};
        // 双旋示例数组
        int[] doubleRotateArray = {10, 11, 7, 6, 8, 9};

        AVLTree tree = new AVLTree();
        tree.add(doubleRotateArray);
        tree.midList();
        System.out.println("未作平衡前：");
        System.out.println("树的高度：" + tree.getRoot().height());
        System.out.println("左子树的高度：" + tree.getRoot().leftHeight());
        System.out.println("右子树的高度：" + tree.getRoot().rightHeight());

    }
}

/**
 * 平衡二叉树
 */
class AVLTree {
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    /**
     * 中序遍历
     */
    public void midList() {
        if (root != null) {
            root.midOrder();
        }
    }

    /**
     * 批量添加新节点
     *
     * @param array
     */
    public void add(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.add(new AVLNode(array[i]));
        }
    }

    /**
     * 添加新节点
     *
     * @param node
     */
    public void add(AVLNode node) {
        if (node == null) {
            return;
        }
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }
}

/**
 * 节点类
 */
class AVLNode {

    int value;

    AVLNode left;

    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    /**
     * 返回当前节点左子树高度
     *
     * @return
     */
    public int leftHeight() {
        if (this.left == null) {
            return 0;
        } else {
            return this.left.height();
        }
    }

    /**
     * 返回当前节点右子树高度
     *
     * @return
     */
    public int rightHeight() {
        if (this.right == null) {
            return 0;
        } else {
            return this.right.height();
        }
    }

    /**
     * 获取当前节点的高度
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(),
                right == null ? 0 : right.height()) + 1;
    }

    /**
     * 左旋方法：
     * 1.创建一个和当前节点的value一样的新节点
     * 2.将新节点的左子节点 改为 当前节点的左子节点
     * 3.将新节点的右子节点 改为 当前节点的右子节点的左子节点
     * 4.将当前节点的值修改为 当前节点的右子节点
     * 5.将当前节点的左子节点改为新节点
     * 6.将当前节点的右子节点改为右子节点的右子节点
     */
    private void leftRotate() {
        AVLNode newNode = new AVLNode(this.value);
        newNode.left = this.left;
        newNode.right = this.right.left;

        this.value = this.right.value;

        this.left = newNode;
        this.right = this.right.right;
    }


    /**
     * 右旋方法：
     * 1.创建一个和当前节点的value一样的新节点
     * 2.将新节点的右子节点 改为 当前节点的右子节点
     * 3.将新节点的左子节点 改为 当前节点的左子节点的右子节点
     * 4.将当前节点的值修改为 当前节点的左子节点
     * 5.将当前节点的右子节点改为新节点
     * 6.将当前节点的左子节点改为左子节点的左子节点
     */
    private void rightRotate() {
        AVLNode newNode = new AVLNode(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;

        this.value = this.left.value;

        this.right = newNode;
        this.left = this.left.left;
    }

    /**
     * 添加新节点
     *
     * @param node
     */
    public void add(AVLNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        // 如果右子树高度大于左子树高度，左旋
        if (rightHeight() - leftHeight() > 1) {
            // 如果当前节点的右节点的右子树高度小于左子树高度，则当前节点的右节点右旋
            if (this.right != null && this.right.rightHeight() < this.right.leftHeight()) {
                this.right.rightRotate();
            }
            leftRotate();
            return;
        }

        // 如果左子树高度大于右子树高度，右旋
        if (leftHeight() - rightHeight() > 1) {
            // 如果当前节点的左节点的左子树高度小于右子树高度，则当前节点的左节点左旋
            if (this.left != null && this.left.leftHeight() < this.left.rightHeight()) {
                this.left.leftRotate();
            }
            rightRotate();
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "value=" + value +
                '}';
    }
}