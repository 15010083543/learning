package com.arithmetic.tree;

import lombok.Data;
// 树节点的基本结构
@Data
public class TreeNode {

    private int value;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    // 前序遍历
    // 先根节点，然后左节点，右节点
    public static void frontCircle(TreeNode treeNode){
        System.out.println(treeNode.value);
        if (null != treeNode.leftNode) {
            frontCircle(treeNode.leftNode);
        }
        if (null != treeNode.rightNode) {
            frontCircle(treeNode.rightNode);
        }

    }

    // 中序遍历
    public void midCircle(TreeNode treeNode){

    }

    // 后序遍历
    public void lastCircle(TreeNode treeNode){

    }
}
