package cn.cc.lib.tree;

/**
 * @author YangGang
 * @date 2021/5/10
 * @desc applied to ...
 */
public class TreeNode {

    public String name;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
