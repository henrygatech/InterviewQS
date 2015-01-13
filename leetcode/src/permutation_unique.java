import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/3.
 */
public class permutation_unique {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
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
        int prev = -67897786;

        for(int i = 0;i<num.size();i++){
            if(prev==num.get(i))
                continue;
            ArrayList<Integer> tmp = (ArrayList<Integer>)num.clone();
            list.add(num.get(i));
            num.remove(i);
            perm(num,list,ret);
            num = tmp;
            list.remove(list.size()-1);
            prev = num.get(i);
        }
    }
    public static void main(String[] args){
        permutation_unique p = new permutation_unique();
        int[] num = {-1,-1,3,-1};
        ArrayList<ArrayList<Integer>> ret =  p.permuteUnique(num);

        for(int i = 0;i<ret.size();i++){
            for(int j = 0;j<ret.get(i).size();j++){
                System.out.println(ret.get(i).get(j));
            }
            System.out.println();
        }


    }

}
