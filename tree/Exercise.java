package cn.cc.lib.tree;

import java.util.List;

/**
 * @author YangGang
 * @date 2021/5/11
 * @desc
 */
class Exercise {

    public static void main(String[] args) {
        TreeNode treeNode = TreeMain.buildTree();
    }

    /**
     * leetcode 872: 叶子相似的树
     *
     * <p>
     * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
     * 输出：true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static boolean isSimilarTree(TreeNode node1, TreeNode node2) {
        List<String> leaves1 = TreeMain.leafInList(node1);
        List<String> leaves2 = TreeMain.leafInList(node2);
        return leaves1.equals(leaves2);
    }
}
