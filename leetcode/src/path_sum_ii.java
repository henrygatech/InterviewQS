import java.util.ArrayList;

/**
 * Created by Henry on 2014/11/28.
 */
public class path_sum_ii {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return ret;
        dfs(root,sum,ret,list);
        return ret;
    }

    public void dfs(TreeNode root, int sum, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> list){

        if(root.left==null&&root.right==null){
            if(sum==root.val){
                list.add(root.val);
                ret.add((ArrayList<Integer>)list.clone());
                //list.remove(list.size()-1);
                return;
            }
        }

        if(root.left!=null){
            list.add(root.val);
            dfs(root.left,sum-root.val,ret,list);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            list.add(root.val);
            dfs(root.right,sum-root.val,ret,list);
            list.remove(list.size()-1);
        }

    }


    public static void main(String[] args){
        path_sum_ii p = new path_sum_ii();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        System.out.print(p.pathSum(t, 3));
    }
}
