package cn.cc.lib.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author YangGang
 * @date 2021/5/10
 * @desc applied to ...
 */
public class TreeMain {

    public static void main(String[] args) {

        TreeNode treeNode = buildTree();
        //DFS算法
//        preOrder(treeNode);
//        middleOrder(treeNode);
//        postOrder(treeNode);

        //BFS算法
        levelOrder(treeNode);
    }

    private static void levelOrder(TreeNode node) {
        List<String> treeLists = levelStore(node);
        for (int i = 0; i < treeLists.size(); i++) {
            System.out.print(treeLists.get(i) + "->");
        }
    }

    protected static List<String> levelStore(TreeNode node) {
        if (node == null) {
            return null;
        }
        ArrayList<String> trees = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            trees.add(temp.name);
            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return trees;
    }

    private static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.name + "->");
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void middleOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        middleOrder(node.left);
        System.out.print(node.name + "->");
        middleOrder(node.right);
    }

    private static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.name + "->");
    }

    /**
     *      A
     *   B      C
     * D   E   F
     */
    private static TreeNode buildTree() {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B (AL)");
        TreeNode nodeC = new TreeNode("C (AR)");
        TreeNode nodeD = new TreeNode("D (BL)");
        TreeNode nodeE = new TreeNode("E (BR)");
        TreeNode nodeF = new TreeNode("F (CL)");

        nodeA.left = nodeB;
        nodeA.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeC.left = nodeF;

        return nodeA;
    }
}
