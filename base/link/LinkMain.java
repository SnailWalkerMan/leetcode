package cn.cc.lib.struct.link;

/**
 * @author YangGang
 * @date 2022/3/23
 * @desc applied to ...
 */
public class LinkMain {

    private static SingleNode<Integer> mockList() {
        SingleNode<Integer> node0 = new SingleNode<>(0);
        SingleNode<Integer> node1 = new SingleNode<>(1);
        node0.next = node1;

        SingleNode<Integer> node2 = new SingleNode<>(2);
        node1.next = node2;

        SingleNode<Integer> node3 = new SingleNode<>(3);
        node2.next = node3;

        SingleNode<Integer> node4 = new SingleNode<>(2);
        node3.next = node4;

        SingleNode<Integer> node5 = new SingleNode<>(1);
        node4.next = node5;

        SingleNode<Integer> node6 = new SingleNode<>(0);
        node5.next = node6;

//        SingleNode<Integer> node7 = new SingleNode<>(0);
//        node6.next = node7;

//        SingleNode<Integer> node8 = new SingleNode<>(8);
//        node7.next = node8;
        return node0;
    }

    public static void main(String[] args) {
        System.out.println(isReverse(mockList()));
    }

    private static boolean isReverse(SingleNode<Integer> node) {
        if (node == null) {
            return false;
        }
        if (node.next == null) {
            return true;
        }
        SingleNode<Integer> fast = node;
        SingleNode<Integer> slow = node;
        //find middle node
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle Point :" + slow.value + "," + fast.next);
        SingleNode<Integer> breakNode = null;
        SingleNode<Integer> compareNode = slow.next;
        //reverse
        if (fast.next == null) {
            //奇数个
            breakNode = slow;
        } else {
            //偶数个
            breakNode = slow.next;
        }
        node = reverseNode(node, breakNode);
        //compare
        SingleNode<Integer> startNode = node;
        boolean result = false;
        while (compareNode.next != null) {
            if (startNode.equalsValue(compareNode)) {
                startNode = startNode.next;
                compareNode = compareNode.next;
                result = true;
            } else {
                result = false;
                break;
            }
        }
        node.print("Reverse");
        //recovery
        node = reverseNode(node, breakNode);
        node.print("Recovery");
        return result;
    }

    private static SingleNode<Integer> reverseNode(SingleNode<Integer> node, SingleNode<Integer> breakNode) {
        SingleNode<Integer> reversePreNode = node;

        while (reversePreNode.next != null
                && reversePreNode.next != breakNode) {
            SingleNode<Integer> reverseNode = reversePreNode.next;
            reversePreNode.next = reverseNode.next;
            reverseNode.next = node;

            node = reverseNode;

            node.print("Reverse Single");
        }
        return node;
    }
}
