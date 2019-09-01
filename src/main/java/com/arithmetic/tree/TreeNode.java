package com.arithmetic.tree;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// 树节点的基本结构
public class TreeNode {

    private int value;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    // 添加节点
    public static void addTreeNode(TreeNode treeNode, TreeNode addNode) throws Exception{
        if (null == treeNode) {
            treeNode.value = addNode.value;
            return ;
        }
        BlockingQueue queue = new LinkedBlockingQueue();
        queue.add(treeNode);
        while (true){
            treeNode = (TreeNode)queue.take();
            // 利用队列的思想添加节点
            if(treeNode.leftNode == null){
                treeNode.leftNode = addNode;
                return;
            } else {
                queue.add(treeNode.leftNode);
            }

            if(treeNode.rightNode == null){
                treeNode.rightNode = addNode;
                return ;
            } else {
                queue.add(treeNode.rightNode);
            }
        }
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

    // 前序查找
    // 先根节点，然后左节点，右节点
    public static void findFrontCircle(TreeNode treeNode){
        System.out.println(treeNode.value);
        if (null != treeNode.leftNode) {
            frontCircle(treeNode.leftNode);
        }
        if (null != treeNode.rightNode) {
            frontCircle(treeNode.rightNode);
        }

    }
}
