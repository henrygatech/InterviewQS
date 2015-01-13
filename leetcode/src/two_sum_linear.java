import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Henry on 2015/1/6.
 */
public class two_sum_linear {

    public ArrayList<ArrayList<Integer>> twoSum(int[] nums, int target){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(nums[i]);
                list.add(nums[map.get(nums[i])]);
                ret.add((ArrayList<Integer>)list.clone());
            }
            else{
                map.put(target-nums[i],i);
            }
        }
        return ret;
    }

    public static void main(String[] args){
        two_sum_linear w = new two_sum_linear();
        int[] nums = {5, 2, 7, 19, 1, 6, 4};
        ArrayList<ArrayList<Integer>> ret =  w.twoSum(nums, 7);
        for(int i = 0;i<ret.size();i++){
            for(int j = 0;j<ret.get(i).size();j++){
                System.out.println(ret.get(i).get(j));
            }
            System.out.println();
        }
    }
}
