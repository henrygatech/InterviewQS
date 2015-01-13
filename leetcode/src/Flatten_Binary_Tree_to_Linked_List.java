/**
 * Created by Henry on 2014/11/27.
 */
public class Flatten_Binary_Tree_to_Linked_List {

    public void flatten(TreeNode root) {
        preorder(root,null);
    }

    public void preorder(TreeNode root, TreeNode pre){
        if(root==null){
            return;
        }
        if(pre!=null){
            pre.right = root;
            pre.left = null;

        }
        pre = root;

        TreeNode record = root.right;
        preorder(root.left,pre);
        preorder(record,pre);
    }

    public static void main(String[] args){
        Flatten_Binary_Tree_to_Linked_List f = new Flatten_Binary_Tree_to_Linked_List();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        f.flatten(t);
    }
}
