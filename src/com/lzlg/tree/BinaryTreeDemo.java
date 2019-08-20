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
        HeroNode node4 = new HeroNode(5, "关胜");

        BinaryTree tree = new BinaryTree(root);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);

//        tree.preList();
//        tree.midList();
//        tree.postList();

//        HeroNode heroNode = tree.postFindById(5);
//        System.out.println(heroNode);

//        tree.deleteNodeById(5);
        tree.deleteNodeById(3);

        tree.preList();

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
     * 删除为此id的节点：
     * 如果是叶子节点，直接删除该节点
     * 如果是非叶子节点，则删除该子树
     *
     * @param id
     */
    public void deleteNodeById(int id) {
        if (root == null) {
            return;
        }
        if (root.getId() == id) {
            root = null;
        }
        root.deleteNodeById(id);
    }

    /**
     * 前序遍历查找id=5的HeroNode
     *
     * @param id
     * @return
     */
    public HeroNode preFindById(int id) {
        if (root == null) {
            return null;
        } else {
            return root.preFindById(id);
        }
    }

    /**
     * 中序遍历查找id=5的HeroNode
     *
     * @param id
     * @return
     */
    public HeroNode midFindById(int id) {
        if (root == null) {
            return null;
        } else {
            return root.midFindById(id);
        }
    }

    /**
     * 后序遍历查找id=5的HeroNode
     *
     * @param id
     * @return
     */
    public HeroNode postFindById(int id) {
        if (root == null) {
            return null;
        } else {
            return root.postFindById(id);
        }
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

    /**
     * 因为该二叉树是单向的，所以不能判断当前节点是否是要删除的节点，
     * 而是先判断当前节点的左右节点是否是要删除的节点，然后递归删除。
     *
     * @param id
     */
    public void deleteNodeById(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }

        // 左递归删除
        if(this.left != null) {
            this.left.deleteNodeById(id);
        }


        // 右递归删除
        if(this.right != null) {
            this.right.deleteNodeById(id);
        }
    }

    public HeroNode postFindById(int id) {
        HeroNode node = null;
        if (this.left != null) {
            node = this.left.postFindById(id);
        }

        if (node != null) {
            return node;
        }

        if (this.right != null) {
            node = this.right.postFindById(id);
        }

        System.out.println("后序遍历===>>>");

        if (this.id == id) {
            return this;
        }
        return node;
    }

    public HeroNode midFindById(int id) {
        HeroNode node = null;
        if (this.left != null) {
            node = this.left.midFindById(id);
        }

        if (node != null) {
            return node;
        }

        System.out.println("中序遍历===>>>");

        if (this.id == id) {
            return this;
        }

        if (this.right != null) {
            node = this.right.midFindById(id);
        }
        return node;
    }

    public HeroNode preFindById(int id) {
        System.out.println("前序遍历<<<===");
        if (this.id == id) {
            return this;
        }

        HeroNode node = null;

        if (this.left != null) {
            node = this.left.preFindById(id);
        }

        if (node != null) {
            return node;
        }

        if (this.right != null) {
            node = this.right.preFindById(id);
        }

        return node;
    }

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