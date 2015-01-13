package com.company;

/**
 * Created by Henry on 2014/12/26.
 */
public class LCA {

    /*
    Design an algorithm and write code to find the first common ancestor of two
    nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE:
    This is not necessarily a binary search tree.
     */
    public boolean cover(TreeNode root, TreeNode node){
        if(root==null){
            return false;
        }
        if(root==node){
            return true;
        }
        return cover(root.left,node)||cover(root.right,node);
    }

    public TreeNode commonAncester(TreeNode root, TreeNode p, TreeNode q){
        boolean pInLeft = cover(root.left,p);
        boolean qInLeft = cover(root.left,q);
        if(pInLeft==true&&qInLeft==true){
            return commonAncester(root.left,p,q);
        }
        else if(pInLeft==false&&qInLeft==false){
            return commonAncester(root.right,p,q);
        }
        else{
            return root;
        }
    }

    public static void main(String[] args){
        LCA l = new LCA();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);
        n.left.right.right = new TreeNode(6);
        System.out.println(l.commonAncester(n, n.left.left, n.left.right.right).val);
    }

}
