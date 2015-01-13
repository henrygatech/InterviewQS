/**
 * Created by Henry on 2014/12/13.
 */
public class flatten_tree {

    TreeNode pre = null;
    public void flatten(TreeNode root) {
        preorder(root);
    }

    public void preorder(TreeNode root){
        if(root==null){
            return;
        }
        if(pre!=null){
            pre.right = root;
            pre.left = null;
        }
        pre = root;
        if(root.left!=null){
            preorder(root.left);
        }
        if(root.right!=null){
            preorder(root.right);
        }
    }

    public  static void main(String[] args){
        flatten_tree f = new flatten_tree();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        f.flatten(t);
    }
}
