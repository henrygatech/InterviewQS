/**
 * Created by Henry on 2014/11/18.
 */
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
}
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    public TreeNode buildTree(int[] inorder,int[] postorder) {
        if(postorder.length!=inorder.length){
            return null;
        }
        if(postorder.length<=0){
            return null;
        }

        return helper(postorder,inorder,0,postorder.length-1,0,inorder.length-1);

    }

    public TreeNode helper(int[] postorder, int[] inorder, int postleft, int postright,int inleft, int inright){

        if((inright-inleft)!=(postright-postleft))
            return null;

        if((postright-postleft)<0)
            return null;


        int rootval = postorder[postright];
        int rootind = -1;
        for(int i = inleft;i<=inright&&i<inorder.length;i++){
            if(inorder[i]==rootval){
                rootind = i;
            }
        }

        TreeNode root = new TreeNode(rootval);
        int rightlen = inright-rootind;
        root.left = helper(postorder,inorder,postleft,postright-rightlen-1,inleft,rootind-1);
        root.right = helper(postorder,inorder,postright-rightlen,postright-1,rootind+1,inright);
        return root;
    }

    public static void main(String[] args){

        Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal c = new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        int[] postorder = {2,1};
        int[] inorder = {2,1};
        c.buildTree(inorder,postorder);

    }

}
