package org.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    TreeNode root;

    public static Tree buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }
        Tree tree = new Tree();

        tree.root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree.root);

        int index = 1;

        while (!queue.isEmpty() && index < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (values[index] != null) {
                current.left = new TreeNode(values[index]);
                queue.offer(current.left);
            }
            index++;

            // Right child
            if (index < values.length && values[index] != null) {
                current.right = new TreeNode(values[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return tree;
    }

    public void printTree() {
        printTree(this.root, 0);
    }

    private void printTree(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        // Print right subtree first
        printTree(node.right, depth + 1);

        // Indentation
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }

        // Print node value
        System.out.println(node.val);

        // Print left subtree
        printTree(node.left, depth + 1);
    }

    public void preorderRecursive() {
        preorderRecursive(this.root);
    }

    private static void preorderRecursive(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    public void inorderRecursive() {
        inorderRecursive(this.root);
    }

    private static void inorderRecursive(TreeNode root) {
        if (root == null) return;
        inorderRecursive(root.left);
        System.out.println(root.val);
        inorderRecursive(root.right);
    }

    public void postorderRecursive() {
        postorderRecursive(this.root);
    }

    private static void postorderRecursive(TreeNode root) {
        if (root == null) return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.println(root.val);
    }

    public void preorderIterative() {
        preorderIterative(this.root);
    }

    private static void preorderIterative(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.println(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    public void inorderIterative() {
        inorderIterative(this.root);
    }

    private static void inorderIterative(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.println(curr.val);

            curr = curr.right;
        }
    }

    public void postorderIterative() {
        postorderIterative(this.root);
    }

    private static void postorderIterative(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode prev = null;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.element();
            if (curr.right != null && curr.right != prev) {
                curr = curr.right;
            } else {
                curr = stack.pop();
                System.out.println(curr.val);
                prev = curr;
                curr = null;
            }
        }
    }

}
