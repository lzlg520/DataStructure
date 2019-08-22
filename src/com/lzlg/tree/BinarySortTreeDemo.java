package com.lzlg.tree;

/**
 * 二叉排序树
 * 将一个数组按照以下规则形成的树是二叉排序树：
 * 1.取出数组的第一个元素，作为根节点
 * 2.取出数组的第二个元素和根节点比较，
 * 如果小于根节点则作为根节点的左子节点（暂定是左子节点）
 * 如果不小于根节点则作为根节点的右子节点
 * 3.然后再取出第三个元素和根节点比较
 * 如果第三个元素是左子节点，则跟第二个元素进行比较，
 * 如果比第二个元素小，则作为第二个元素的左子节点
 * 如果不小于第二个元素，则作为第二个元素的右子节点
 * 4.然后将数组其他元素依照1，2，3步骤形成的二叉树就叫做二叉排序树
 * 5.二叉排序树的特点：中序遍历是从小到大排列
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
//        int[] array = {7, 3, 10, 12, 5, 1, 9, 2};
        int[] array = {1, 2, 3, 4, 5};
        BinarySortTree tree = new BinarySortTree();
        for (int i = 0; i < array.length; i++) {
            tree.add(new SortNode(array[i]));
        }
        tree.midList();

//        tree.deleteNode(7);
//        tree.deleteNode(3);
//
//        tree.deleteNode(12);
//        tree.deleteNode(5);
//        tree.deleteNode(2);
//        tree.deleteNode(9);
//        tree.deleteNode(10);
//
//        tree.deleteNode(1);

//        tree.deleteNode(1);
        tree.deleteNode(2);
//        tree.deleteNode(3);
        System.out.println("节点删除后遍历：");
        tree.midList();
    }
}

/**
 * 二叉排序树
 */
class BinarySortTree {
    private SortNode root;

    /**
     * 中序遍历
     */
    public void midList() {
        if (root == null) {
            System.out.println("二叉排序树为空，不能遍历");
        } else {
            root.midOrder();
        }
    }

    /**
     * 根据value值查找对应的节点
     *
     * @param value
     * @return
     */
    private SortNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 根据value值查找节点的父节点
     *
     * @param value
     * @return
     */
    private SortNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 根据value值删除指定节点：
     * 有三种情况：
     * 1.该节点是叶子节点
     * 2.该节点只有左子节点或右子节点
     * 3.该节点是同时有左子节点和右子节点
     *
     * @param value
     */
    public void deleteNode(int value) {
        if (root == null) {
            return;
        }
        SortNode targetNode = search(value);
        if (targetNode == null) {
            return;
        } else {
            if (root.value == value) {// 判断是不是根节点
                root = null;
                return;
            }
            SortNode parentNode = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) { // 要删除的节点是叶子节点
                if (value < parentNode.value) {// 判断该叶子节点是父节点的左子节点还是右子节点
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {// 情况3
//                int minValue = deleteRightNodeAndReturnMinValue(targetNode);
//                targetNode.value = minValue;
                int maxValue = deleteLeftNodeAndReturnMaxValue(targetNode);
                targetNode.value = maxValue;
            } else { // 情况2
                if (parentNode == null) {// 考虑只有两个元素的二叉树情况，
                    // 这时要删除的是根节点，就没有parentNode
                    root = targetNode.left == null ? targetNode.right : targetNode.left;
                } else {
                    if (value < parentNode.value) {// targetNode是左子节点
                        parentNode.left = targetNode.left == null ? targetNode.right : targetNode.left;
                    } else {// targetNode是右子节点
                        parentNode.right = targetNode.left == null ? targetNode.right : targetNode.left;
                    }
                }
            }
        }
    }

    /**
     * 查找到Node节点的最大值节点，删除并返回最大值
     *
     * @param targetNode
     * @return
     */
    private int deleteLeftNodeAndReturnMaxValue(SortNode targetNode) {
        SortNode temp = targetNode;
        while (temp.right != null) { // 右子节点的值较大
            temp = temp.right;
        }
        deleteNode(temp.value);
        return temp.value;
    }

    /**
     * 查找到Node节点的最小值节点，删除并返回最小值
     *
     * @param targetNode
     * @return
     */
    private int deleteRightNodeAndReturnMinValue(SortNode targetNode) {
        SortNode temp = targetNode;
        while (temp.left != null) { // 左子节点的值较小
            temp = temp.left;
        }
        deleteNode(temp.value);
        return temp.value;
    }

    /**
     * 批量添加新节点
     *
     * @param array
     */
    public void add(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.add(new SortNode(array[i]));
        }
        this.midList();
    }

    /**
     * 添加新节点
     *
     * @param node
     */
    public void add(SortNode node) {
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
class SortNode {
    int value;
    SortNode left;
    SortNode right;

    public SortNode(int value) {
        this.value = value;
    }

    /**
     * 查询指定value节点的父节点
     *
     * @param value
     * @return
     */
    public SortNode searchParent(int value) {
        // 判断当前节点的左子节点和右子节点的值是不是value
        if (this.left != null && this.left.value == value) {
            return this;
        }
        if (this.right != null && this.right.value == value) {
            return this;
        }

        // 如果都不是，则根据value值和this.value值比较递归查找
        if (value < this.value) {
            if (this.left != null) {
                return this.left.searchParent(value);
            } else {
                return null;
            }
        } else {
            if (this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }

    }

    /**
     * 查找指定value的节点
     *
     * @param value
     * @return
     */
    public SortNode search(int value) {
        if (value == this.value) {
            return this;
        }
        if (value < this.value) {
            if (this.left != null) {
                return this.left.search(value);
            } else {
                return null;
            }
        } else {
            if (this.right != null) {
                return this.right.search(value);
            } else {
                return null;
            }
        }
    }

    /**
     * 添加新节点
     *
     * @param node
     */
    public void add(SortNode node) {
        if (node.value < this.value) {// 小于当前节点值的作为左子节点
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {// 不小于当前节点值的作为右子节点
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
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
        return "SortNode{" +
                "value=" + value +
                '}';
    }
}