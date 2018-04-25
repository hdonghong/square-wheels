package _03_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BinTree class<br/>
 *
 * @author hdonghong
 * @date 2018/04/20
 */
public class BinTree<E> {

/* 递归 */
    /** 先序遍历 */
    public void preOrderTraversal(TNode<E> tree) {
        if (tree != null) {
            System.out.println(tree.data);
            preOrderTraversal(tree.left);
            preOrderTraversal(tree.right);
        }
    }

    /** 中序遍历 */
    public void inOrderTraversal(TNode<E> tree) {
        if (tree != null) {
            inOrderTraversal(tree.left);
            System.out.println(tree.data);
            inOrderTraversal(tree.right);
        }
    }

    /** 后序遍历 */
    public void postOrderTraversal(TNode<E> tree) {
        if (tree != null) {
            postOrderTraversal(tree.left);
            postOrderTraversal(tree.right);
            System.out.println(tree.data);
        }
    }

    /* 堆栈，先序遍历 */
    public void preOrderTraversalByStack(TNode<E> tree) {

        Stack<TNode<E>> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                System.out.println(tree.data);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                stack.push(tree.right);
            }
        }
    }

    /* 堆栈，中序遍历 */
    public void inOrderTraversalByStack(TNode<E> tree) {
        Stack<TNode<E>> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                System.out.println(tree.data);
                stack.push(tree.right);
            }
        }
    }

    /* 堆栈，后序遍历 */
    public void postOrderTraversalByStack(TNode<E> tree) {
        Stack<TNode<E>> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null && !tree.visited) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                if (tree.right == null || tree.visited) {
                    System.out.println(tree.data);
                } else {
                    tree.visited = true;
                    stack.push(tree);
                }
                tree = tree.right;
            }
        }
    }

    /* 层次遍历 队列实现 */
    public void levelOrderTraversalByQ(TNode<E> tree) {
        if (tree == null) {
            return;
        }
        Queue<TNode<E>> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            tree = queue.poll();
            System.out.println(tree.left);
            if (tree.left != null) {
                queue.add(tree.left);
            }
            if (tree.right != null) {
                queue.add(tree.right);
            }
        }
    }

    /* 层次遍历 堆栈实现 */
    public void levelOrderTraversalByStack(TNode<E> tree) {
        /* 没想出来，(⊙o⊙) */
    }
}
