/**
 * Created by Henry on 2014/12/16.
 */
public class treePlus {
    public TreeNode plus(TreeNode t1, TreeNode t2){
        if(t1==null&&t2==null){
            return null;
        }
        TreeNode ret = null;
        if(t1.left==null&&t1.right==null||t2.left==null&&t2.right==null){
            if(t1.val*t2.val==0){
                ret = new TreeNode(0);
                return ret;
            }
            else if(t1.val*t2.val==1){
                ret = new TreeNode(1);
                return ret;
            }
            else if(t1.val*t2.val==-1){
                if(t1.val==-1)
                    ret = t1;
                else if(t2.val == -1)
                    ret = t2;
                return ret;
            }
        }
        ret = new TreeNode(-1);
        ret.left = plus(t1.left,t2.left);
        ret.right = plus(t1.right,t2.right);
        return ret;
    }

    public void preorder(TreeNode t){
        if(t==null){
            return;
        }

        System.out.println(t.val);
        preorder(t.left);
        preorder(t.right);
    }

    public static void main(String[] args){
        treePlus t = new treePlus();
        TreeNode t1 = new TreeNode(-1);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(0);
        TreeNode t2 = new TreeNode(-1);
        t2.left = new TreeNode(-1);
        t2.right = new TreeNode(1);
        t2.left.left = new TreeNode(0);
        t2.left.right = new TreeNode(0);
        TreeNode ret = t.plus(t1,t2);
        t.preorder(ret);

    }
}
