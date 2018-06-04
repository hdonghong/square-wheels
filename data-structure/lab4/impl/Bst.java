package impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Bst class<br/>
 *
 * 在一棵二叉链表表示的二叉树中，实现以下操作，并说明采用哪种遍历算法，其他遍历算法是否可行。
 * 分析：题意很迷。。。那我就选择bst吧
 * @author hdonghong
 * @date 2018/05/31
 */
public class Bst<T extends Comparable<T>> {

    private Node root;
    private int size;

    public Bst() {
        root = null;
        size = 0;
    }

    public void add(T t) {
        root = add(t, root);
    }
    private Node add(T t, Node node) {
        if (node == null) {
            ++size;
            return new Node(t);
        }
        if (t.compareTo(node.data) < 0) {
            node.left = add(t, root.left);
        }
        if (t.compareTo(node.data) > 0) {
            node.right = add(t, node.right);
        }
        return node;
    }

    /** 数叶子，基于迭代中序遍历 */
    public int countLeaves() {
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        int result = 0;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (leaf(node)) {
                    ++result;
                } else {
                    node = node.right;
                }
            }
        }
        return result;
    }

    /** 交换左右子树 */
    public void changeChildren() {
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.right != null && !list.contains(node)) {
                    list.add(node);
                    stack.push(node);
                    node = node.right;
                } else {
                    Node temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                    node = null;
                }
            }
        }

    }

    /** 验证性质：验证二叉树的性质3：n0=n2+1。*/
    public boolean validate() {
        return true;
    }

    /** 输出比K打的数 */
    public void printGtK(T k) {
        Node node = this.root;
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.data.compareTo(k) > 0) {
                    System.out.print(node.data + " ");
                }
                node = node.right;
            }
        }
    }

    /** 已知先根和中根次序遍历序列构造二叉树。 */
    public Bst constructBt(T[] preOrderArr, T[] inOrderArr) {
        return null;
    }

    public int size() {
        return size;
    }

    private boolean leaf(Node node) {
        return node.left == null && node.right == null;
    }

    private class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
        }
    }


    public void postOrder() {
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.right != null && !list.contains(node)) {
                    list.add(node);
                    stack.push(node);
                    node = node.right;
                } else {
                    System.out.print(node.data + " ");
                    node = null;
                }
            }
        }

    }

    public Bst copyTree() {

        return null;
    }
}
