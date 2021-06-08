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

        TreeNode<String> treeNode = buildTree();
        //DFS算法
//        preOrder(treeNode);
//        middleOrder(treeNode);
//        postOrder(treeNode);

        //BFS算法
//        levelOrder(treeNode);

//        List<String> leaves = leafInList(mockSimilarData());
//        for (String leaf : leaves) {
//            System.out.println(leaf);
//        }
        System.out.println("1--->"+request(true,true));
        System.out.println("1--->"+request(true,false));
        System.out.println("1--->"+request(false,false));
    }

    public static boolean request(boolean a, boolean b) {
        return a ^ b;
    }

    private static void levelOrder(TreeNode<String> node) {
        List<String> treeLists = levelStore(node);
        for (int i = 0; i < treeLists.size(); i++) {
            System.out.print(treeLists.get(i) + "->");
        }
    }

    protected static List<String> levelStore(TreeNode<String> node) {
        if (node == null) {
            return null;
        }
        ArrayList<String> trees = new ArrayList<>();
        LinkedList<TreeNode<String>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode<String> temp = queue.poll();
            trees.add(temp.value);
            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return trees;
    }

    private static void preOrder(TreeNode<String> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + "->");
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void middleOrder(TreeNode<String> node) {
        if (node == null) {
            return;
        }
        middleOrder(node.left);
        System.out.print(node.value + "->");
        middleOrder(node.right);
    }

    private static void postOrder(TreeNode<String> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + "->");
    }

    /**
     * A
     * B      C
     * D   E   F
     */
    public static TreeNode<String> buildTree() {
        TreeNode<String> nodeA = new TreeNode<>("A");
        TreeNode<String> nodeB = new TreeNode<>("B (AL)");
        TreeNode<String> nodeC = new TreeNode<>("C (AR)");
        TreeNode<String> nodeD = new TreeNode<>("D (BL)");
        TreeNode<String> nodeE = new TreeNode<>("E (BR)");
        TreeNode<String> nodeF = new TreeNode<>("F (CL)");

        nodeA.left = nodeB;
        nodeA.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeC.left = nodeF;

        return nodeA;
    }

    /*****************LeetCode 872*****************/

    public static TreeNode<String> mockSimilarData() {
        TreeNode<String> treeNode1 = new TreeNode<>("3");
        TreeNode<String> treeNode2 = new TreeNode<>("5");
        TreeNode<String> treeNode3 = new TreeNode<>("1");
        TreeNode<String> treeNode4 = new TreeNode<>("6");
        TreeNode<String> treeNode5 = new TreeNode<>("2");
        TreeNode<String> treeNode6 = new TreeNode<>("9");
        TreeNode<String> treeNode7 = new TreeNode<>("8");
        TreeNode<String> treeNode8 = new TreeNode<>("7");
        TreeNode<String> treeNode9 = new TreeNode<>("4");

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


    public static List<String> leafInList(TreeNode<String> node) {
        List<String> list = new ArrayList<>();
        bfs(node, list);
        return list;
    }

    private static void dfs(TreeNode<String> node, List<String> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.value);
        } else {
            dfs(node.left, list);
            dfs(node.right, list);
        }
    }

    private static void bfs(TreeNode<String> root, List<String> list) {
        LinkedList<TreeNode<String>> nodeLinkedList = new LinkedList<>();
        while (root != null || !nodeLinkedList.isEmpty()) {
            while (root != null) {
                nodeLinkedList.offer(root);
                root = root.left;
            }
            root = nodeLinkedList.pollLast();
            if (root != null) {
                if (root.left == null && root.right == null) {
                    list.add(root.value);
                }
                root = root.right;
            }
        }
    }
}
