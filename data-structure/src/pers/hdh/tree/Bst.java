package pers.hdh.tree;

/**
 * Bst class<br/>
 * 二分搜索树
 * @author hdonghong
 * @date 2018/05/09
 */
public class Bst <E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public Bst() {
        root = null;
        size = 0;
    }

    /** 递归增加元素 */
    public void addByRecusion(E e) {
        /*
        if (root == null) {
            ++size;
            root = new Node(e);
        } else {
            addByRecusion(root, e);
        }
        */
        root = addByRecusion(root, e);
    }
    private Node addByRecusion(Node node, E e) {
        /*
        // 这样的终止条件过于臃肿，考虑把null也视为一颗树，这样的话方法就需要有返回值
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
        }

        if (e.compareTo(node.e) < 0) { addByRecusion(node.left, e); }
        else if (e.compareTo(node.e) > 0) { addByRecusion(node.right, e); }
        */
        if (node == null) {
            ++size;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) { node.left = addByRecusion(node.left, e); }
        else if (e.compareTo(node.e) > 0) { node.right = addByRecusion(node.right, e); }
        return node;
    }

    /** 增加元素 */
    public void add(E e) {
        if (e == null) {
            throw new IllegalArgumentException("emmm null e ?");
        }

        if (root == null) {
            ++size;
            root = new Node(e);
            return;
        }
        Node cur = root;
        while (cur != null) {
            if (e.compareTo(cur.e) < 0) {
                if (cur.left == null) {
                    cur.left = new Node(e);
                    break;
                }
                cur = cur.left;
            } else if (e.compareTo(cur.e) > 0) {
                if (cur.right == null) {
                    cur.right = new Node(e);
                    break;
                }
                cur = cur.right;
            } else {
                return;
            }
        }
        ++size;
    }

    /** 查看是否存在e */
    public boolean containsByRecusion(E e) {
        return contains(root, e);
    }
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        int result = e.compareTo(node.e);

        if (result < 0) {
            return contains(node.left, e);
        }
        if (result > 0) {
            return contains(node.right, e);
        }
        return true;
    }

    /** 迭代实现 TODO */
    public boolean contains(E e) {
        return false;
    }

    /** 先序遍历，递归实现 */
    public void preOrderByRecusion() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /** 中序遍历，递归实现 */
    public void inOrderByRecusion() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }


    /** 后序遍历，递归实现 */
    public void OrderByRecusion() {
        inOrder(root);
    }
    private void sOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        generateBSTString(root, 0, result);
        return result.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder result) {
        if (node == null) {
            result.append(generateDepthString(depth) + "null\n");
        }

        result.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, result);
        generateBSTString(node.right, depth + 1, result);
    }
    private String generateDepthString(int depth) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            result.append("--");
        }
        return result.toString();
    }
}
