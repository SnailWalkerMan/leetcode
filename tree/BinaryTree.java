package cn.cc.lib.tree;

/**
 * @author YangGang
 * @date 2021/5/12
 * @desc applied to ...
 */
class BinaryTree {

    private TreeNode<Integer> mTreeNode;

    public BinaryTree(TreeNode<Integer> node) {
        mTreeNode = node;
    }

    public TreeNode<Integer> search(int data) {
        TreeNode<Integer> p = mTreeNode;
        while (p != null) {
            if (data < p.value) {
                p = p.left;
            } else {
                if (data > p.value) {
                    p = p.right;
                } else {
                    return p;
                }
            }
        }
        return null;
    }

    public void insert(int data) {
        if (mTreeNode == null) {
            mTreeNode = new TreeNode<>(data);
        } else {
            TreeNode<Integer> p = mTreeNode;
            while (p != null) {
                if (data > p.value) {
                    if (p.right == null) {
                        p.right = new TreeNode<>(data);
                        return;
                    }
                    p = p.right;
                } else {
                    if (p.left == null) {
                        p.left = new TreeNode<>(data);
                        return;
                    }
                    p = p.left;
                }
            }
        }
    }

    public void delete(int data) {
        if (mTreeNode == null) {
            return;
        }
        TreeNode<Integer> pp = null;
        TreeNode<Integer> p = mTreeNode;
        while (p != null && p.value != data) {
            pp = p;
            if (data > p.value) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p != null) {
            // 删除的节点有两个子节点
            if (p.left != null && p.right != null) {
                TreeNode<Integer> minP = p.right;
                TreeNode<Integer> minPP = null;
                while (minP.left != null) {
                    minPP = minP;
                    minP = minP.left;
                }
                p.value = minP.value;
                p = minP;
                pp = minPP;
            }

            TreeNode<Integer> child;
            if (p.left != null) {
                child = p.left;
            } else if (p.right != null) {
                child = p.right;
            } else {
                child = null;
            }
            if (pp == null) {
                mTreeNode = child;
            } else {
                if (pp.left == p) {
                    pp.left = child;
                } else {
                    pp.right = child;
                }
            }
        }
    }

    private static TreeNode<Integer> buildIntTree() {
        TreeNode<Integer> treeNode0 = new TreeNode<>(33);
        TreeNode<Integer> treeNode1 = new TreeNode<>(17);
        TreeNode<Integer> treeNode2 = new TreeNode<>(50);
        TreeNode<Integer> treeNode3 = new TreeNode<>(13);
        TreeNode<Integer> treeNode4 = new TreeNode<>(18);
        TreeNode<Integer> treeNode5 = new TreeNode<>(34);
        TreeNode<Integer> treeNode6 = new TreeNode<>(58);
        TreeNode<Integer> treeNode7 = new TreeNode<>(16);
        TreeNode<Integer> treeNode8 = new TreeNode<>(25);
        TreeNode<Integer> treeNode9 = new TreeNode<>(51);
        TreeNode<Integer> treeNode10 = new TreeNode<>(66);
        TreeNode<Integer> treeNode11 = new TreeNode<>(19);
        TreeNode<Integer> treeNode12 = new TreeNode<>(27);

        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        treeNode3.right = treeNode7;

        treeNode4.right = treeNode8;

        treeNode6.left = treeNode9;
        treeNode6.right = treeNode10;

        treeNode8.left = treeNode11;
        treeNode8.right = treeNode12;
        return treeNode0;
    }

}
