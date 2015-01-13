import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by Henry on 2015/1/8.
 */
public class PreorderIterator {

    private TreeNode next;
    private Stack<TreeNode> s;

    public PreorderIterator(TreeNode root){
        s = new Stack<TreeNode>();
        if(root!=null)
        s.push(root);
    }

    public boolean hasNext(){
        return !s.isEmpty();
    }

    public TreeNode next(){
        if(hasNext()){
            TreeNode tmp = s.pop();
            if(tmp.right!=null)
                s.push(tmp.right);
            if(tmp.left!=null){
                s.push(tmp.left);
            }
            return tmp;
        }
        else return null;
    }

    public static void main(String[] args){
        		/*
		 *       1
		 *     2  3
		 *   4  5 6  7
		 *
		 */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        PreorderIterator test = new PreorderIterator(root);
        System.out.println(test.hasNext());
        while(test.hasNext()){
            System.out.println(test.next().val);
        }
    }
}
