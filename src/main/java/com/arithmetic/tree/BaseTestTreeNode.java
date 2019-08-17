package com.arithmetic.tree;

public class BaseTestTreeNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(5);
        TreeNode left2 = new TreeNode(6);
        TreeNode right2 = new TreeNode(7);

        root.leftNode = left;
        root.rightNode = right;
        left.leftNode = left1;
        left.rightNode = right1;
        right.leftNode = left2;
        right.rightNode = right2;
        System.out.println("--------------拼装树结构---------------");

    }
}
