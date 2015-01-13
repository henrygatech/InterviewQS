import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Henry on 2015/1/1.
 */
public class binary_inorder {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<Integer>();
        if(root==null)
            return ret;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode tmp = s.peek();
            while(tmp.left!=null){
                TreeNode leftnd = tmp.left;
                if(leftnd.left!=null){
                    s.push(leftnd);
                }
                tmp.left = null;
                tmp = leftnd;
            }
            ret.add(tmp.val);
            if(tmp.right!=null){
                s.push(tmp.right);
                continue;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        binary_inorder b = new binary_inorder();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        b.inorderTraversal(n);
    }
}
