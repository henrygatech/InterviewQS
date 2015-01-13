import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/3.
 */
public class permutation {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int i = 0;i<num.length;i++){
            numList.add(num[i]);
        }
        perm(numList,list,ret);
        return ret;
    }

    public void perm(ArrayList<Integer> num, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ret){

        if(num.size()==0){
            ret.add((ArrayList<Integer>)list.clone());
            return;
        }

        for(int i = 0;i<num.size();i++){
            ArrayList<Integer> tmp = (ArrayList<Integer>)num.clone();
            list.add(num.get(i));
            num.remove(i);
            perm(num,list,ret);
            num = tmp;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        permutation p = new permutation();
        int[] num = {1};
        p.permute(num);
    }
}
