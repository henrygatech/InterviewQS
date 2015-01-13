/**
 * Created by Henry on 2014/11/29.
 */
public class symmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        else if(left!=null){
            return false;
        }
        else if(right!=null){
            return false;
        }

        if(left.val!=right.val){
            return false;
        }

        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }

    public static void main(String[] args){
        symmetricTree s = new symmetricTree();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(2);
        s.isSymmetric(t);
    }
}
