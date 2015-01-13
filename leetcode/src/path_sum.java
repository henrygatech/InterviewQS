/**
 * Created by Henry on 2014/11/28.
 */
public class path_sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        return dfs(root,sum);
    }

    public boolean dfs(TreeNode root, int sum){

        if(root==null&&sum==0){
            return true;
        }
        else if(sum<0){
            return false;
        }
        else if(root==null){
            return false;
        }

        return (dfs(root.left,sum-root.val)||dfs(root.right,sum-root.val));
    }

    public static void main(String[] args){
        path_sum p = new path_sum();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        System.out.print(p.hasPathSum(t, 1));
    }
}
