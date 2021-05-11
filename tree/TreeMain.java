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
//        levelOrder(treeNode);

        List<String> leaves = leafInList(mockSimilarData());
        for (String leaf : leaves) {
            System.out.println(leaf);
        }
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
     * A
     * B      C
     * D   E   F
     */
    public static TreeNode buildTree() {
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

    /*****************LeetCode 872*****************/

    public static TreeNode mockSimilarData() {
        TreeNode treeNode1 = new TreeNode("3");
        TreeNode treeNode2 = new TreeNode("5");
        TreeNode treeNode3 = new TreeNode("1");
        TreeNode treeNode4 = new TreeNode("6");
        TreeNode treeNode5 = new TreeNode("2");
        TreeNode treeNode6 = new TreeNode("9");
        TreeNode treeNode7 = new TreeNode("8");
        TreeNode treeNode8 = new TreeNode("7");
        TreeNode treeNode9 = new TreeNode("4");

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;

        return treeNode1;
    }


    public static List<String> leafInList(TreeNode node) {
        List<String> list = new ArrayList<>();
        bfs(node, list);
        return list;
    }

    private static void dfs(TreeNode node, List<String> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.name);
        } else {
            dfs(node.left, list);
            dfs(node.right, list);
        }
    }

    private static void bfs(TreeNode root, List<String> list) {
        LinkedList<TreeNode> nodeLinkedList = new LinkedList<>();
        while (root != null || !nodeLinkedList.isEmpty()) {
            while (root != null) {
                nodeLinkedList.offer(root);
                root = root.left;
            }
            root = nodeLinkedList.pollLast();
            if (root.left == null && root.right == null) {
                list.add(root.name);
            }
            root = root.right;
        }
    }
}
