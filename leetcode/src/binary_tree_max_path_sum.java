/**
 * Created by Henry on 2014/11/27.
 */
public class binary_tree_max_path_sum {

    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum = 0;
        dfs(root,0);
        return max;
    }

    public void dfs(TreeNode root, int cur){

        if(cur>0)
            max = Math.max(cur+root.val,max);
        else
            max = Math.max(root.val,max);

        if(root.left==null&&root.right==null){
            return;
        }
        if(root.left!=null){
            if(cur>0)
                dfs(root.left,cur+root.val);
            else
                dfs(root.left,root.val);
        }
        if(root.right!=null){
            if(cur>0)
                dfs(root.right,cur+root.val);
            else
                dfs(root.right,root.val);
        }
    }


    public static void main(String[] args){
        binary_tree_max_path_sum b = new binary_tree_max_path_sum();
        TreeNode t = new TreeNode(1);
        //b.maxPathSum();
    }
}
