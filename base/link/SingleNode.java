package cn.cc.lib.struct.link;

/**
 * @author YangGang
 * @date 2022/3/23
 * @desc applied to ...
 */
public class SingleNode<T> {

    public T value;
    public SingleNode<T> next;

    public SingleNode(T t) {
        value = t;
    }

    public boolean equalsValue(SingleNode<T> node) {
        if (value == null) {
            return node.value == null;
        } else {
            return value.equals(node.value);
        }
    }

    public void print(String tag) {
        StringBuilder nodeBuilder = new StringBuilder();
        if (tag != null) {
            nodeBuilder.append(tag).append(":");
        }
        nodeBuilder.append("Node").append("{").append(value);
        SingleNode<T> tmpNode = next;
        while (tmpNode != null) {
            nodeBuilder.append(",").append(tmpNode.value);
            tmpNode = tmpNode.next;
        }
        nodeBuilder.append("}");
        System.out.println(nodeBuilder);
    }
}
