package com.company;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/26.
 */
public class path_sum_4_9 {
    /*
    You are given a binary tree in which each node contains a value.
    Design an algorithm to print all paths which sum to a given value.
    The path does not need to start or end at the root or a leaf.
    */

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root,int target){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root,target,0,list,ret);
        return ret;
        //helper();
    }

    public void helper(TreeNode root,int target,int sum,ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ret){
        if(root==null){
            return;
        }
        ArrayList<Integer> tmp = (ArrayList<Integer>)list.clone();
        sum +=root.val;
        list.add(root.val);
        if(sum>target) {
            list.remove(list.size() - 1);
            return;
        }
        if(target==sum){
            ret.add((ArrayList<Integer>)list.clone());
            list.remove(list.size()-1);
            return;
        }


        helper(root.left, target, sum, list, ret);
        helper(root.right, target, sum, list, ret);
        helper(root.left,target,0,new ArrayList<Integer>(),ret);
        helper(root.right,target,0,new ArrayList<Integer>(),ret);

    }

    public static void main(String[] args){
            /*
              11
             / \
            4   8
           /   / \
          11  7   5
         /  \    / \
        7    4  10   1
     */
        TreeNode n = new TreeNode(11);
        n.left = new TreeNode(4);
        n.right = new TreeNode(8);
        n.left.left = new TreeNode(11);
        n.right.left = new TreeNode(7);
        n.right.right = new TreeNode(5);
        n.left.left.left = new TreeNode(7);
        n.left.left.right = new TreeNode(4);
        n.right.right.left = new TreeNode(10);
        n.right.right.right = new TreeNode(1);

        path_sum_4_9 p = new path_sum_4_9();
        ArrayList<ArrayList<Integer>> ret = p.pathSum(n, 15);
        for(int i = 0;i<ret.size();i++){
            for(int j =0;j<ret.get(i).size();j++){
                System.out.println(ret.get(i).get(j));
            }
            System.out.println();
        }
    }

}
