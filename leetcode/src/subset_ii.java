import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Henry on 2014/12/14.
 */
public class subset_ii {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ret.add(new ArrayList<Integer>());
        dfs(num,0,list,ret);
        return ret;
    }

    public void dfs(int[] num, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ret){
        if(start==num.length){
            ret.add((ArrayList<Integer>)list.clone());
            return;
        }
        if(start>num.length)
            return;
        for(int i = start;i<num.length;i++){
            list.add(num[i]);
            dfs(num,i+1,list,ret);
            list.remove(list.size()-1);
            while(i+1<num.length&&num[i]==num[i+1]) i++;
        }
    }

    public static void main(String[] args){
        subset_ii s = new subset_ii();
        int[] num = {1,1};
        s.subsetsWithDup(num);
    }
}
