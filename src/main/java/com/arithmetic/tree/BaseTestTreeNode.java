package com.arithmetic.tree;

public class BaseTestTreeNode {

    public static void main(String[] args)  {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(5);
        TreeNode left2 = new TreeNode(6);
        TreeNode right2 = new TreeNode(7);


        try {
            TreeNode.addTreeNode(root, left);
            TreeNode.addTreeNode(root, right);
            TreeNode.addTreeNode(root, left1);
            TreeNode.addTreeNode(root, right1);
            TreeNode.addTreeNode(root, left2);
            TreeNode.addTreeNode(root, right2);
        } catch (Exception e) {
            e.printStackTrace();
        }
       /* root.leftNode = left;
        root.rightNode = right;
        left.leftNode = left1;
        left.rightNode = right1;
        right.leftNode = left2;
        right.rightNode = right2;*/
        System.out.println("--------------拼装树结构---------------");

        TreeNode.lastCircle(root);

    }
}
