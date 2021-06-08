package cn.cc.lib.tree;

/**
 * @author YangGang
 * @date 2021/5/10
 * @desc applied to ...
 */
public class TreeNode<T> {

    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {

    }

    public TreeNode(T name) {
        this.value = name;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
