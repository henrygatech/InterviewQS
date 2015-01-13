package com.company;

/**
 * Created by Henry on 2014/12/26.
 */
class TreeNodeWithParent{
    TreeNodeWithParent left;
    TreeNodeWithParent right;
    TreeNodeWithParent parent;
    int val;
    public TreeNodeWithParent(int v){
        val = v;
    }

}

public class successor {

    /*
    Write an algorithm to find the'next'node (i.e., in-order successor) of a given node
    in a binary search tree. You may assume that each node has a link to its parent.
    */

    //given link to parent
    public TreeNodeWithParent findInorder(TreeNodeWithParent root){
        TreeNodeWithParent parent = root.parent;
        if(root.right!=null){
            //find and return leftmost child
            return leftMostChild(root);
        }
        else{
            TreeNodeWithParent nd = root;
            while(nd.parent!=null&&nd == nd.parent.right){
                nd = nd.parent;
            }
            return nd.parent;
        }
    }

    public TreeNodeWithParent leftMostChild(TreeNodeWithParent root){
        TreeNodeWithParent nd = root.right;
        if(nd==null){
            return null;
        }
        while(nd.left!=null&&nd.right!=null){
            nd = nd.left;
        }
        return nd;
    }

    public TreeNode findInorder(TreeNode root, TreeNode node){
        if(node.right!=null){
            //find and return leftmost child
            return leftMostChild(node);
        }
        else{
            TreeNode pre = null;
            while(root!=null){
                if(root.val>node.val){
                    pre = root;
                    root = root.left;
                }
                else if(root.val<node.val){
                    root = root.right;
                }
                else {
                    return pre;
                }
            }
            return null;
        }
    }

    public TreeNode leftMostChild(TreeNode root){
        TreeNode nd = root.right;
        if(nd==null){
            return null;
        }
        while(nd.left!=null&&nd.right!=null){
            nd = nd.left;
        }
        return nd;
    }


    public static void main(String[] args){
        successor s = new successor();
        /*
        TreeNodeWithParent t0 = new TreeNodeWithParent(0);
        TreeNodeWithParent t = new TreeNodeWithParent(1);
        t.left = new TreeNodeWithParent(2);
        t.left.parent = t;
        t.right = new TreeNodeWithParent(3);
        t.right.parent = t;
        t.right.right = new TreeNodeWithParent(4);
        t.right.right.parent = t.right;
        t.right.right.right = new TreeNodeWithParent(5);
        t.right.right.right.parent = t.right.right;
        t0.left = t;
        t.parent = t0;
        System.out.println(s.findInorder(t.right).val);
        */
        TreeNode t0 = new TreeNode(6);
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(1);
        t.right = new TreeNode(3);
        t.right.right = new TreeNode(4);
        t.right.right.right = new TreeNode(5);
        t0.left = t;
        System.out.println(s.findInorder(t0,t.right.right.right).val);
    }

}
