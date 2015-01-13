package com.company;

import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/26.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class level_order_traversal_4_4 {
    /*
    Given a binary tree, design an algorithm which creates a linked list of all the
    nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked
    lists).
     */

    public ArrayList<ArrayList<TreeNode>> createList(TreeNode root){
        ArrayList<ArrayList<TreeNode>> ret = new  ArrayList<ArrayList<TreeNode>>();
        helper(root,0,ret);
        return ret;
    }

    public void helper(TreeNode root, int level,ArrayList<ArrayList<TreeNode>> ret){
        if(root==null){
            return;
        }
        if(level==ret.size()){
            ret.add(new ArrayList<TreeNode>());
        }
        ArrayList<TreeNode> list = ret.get(level);
        list.add(root);
        helper(root.left,level+1,ret);
        helper(root.right,level+1,ret);
    }

    public static void main(String[] args){
        level_order_traversal_4_4 l = new level_order_traversal_4_4();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.right.left = new TreeNode(5);
        ArrayList<ArrayList<TreeNode>> ret =l.createList(t);
        ArrayList<TreeNode> tmp = ret.get(1);
        for(TreeNode n:tmp){
            System.out.println(n.val);
        }
    }
}
