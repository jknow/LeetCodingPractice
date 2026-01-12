package org.example;

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

}
