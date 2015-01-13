import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Henry on 2014/12/6.
 */
public class threesum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0;i<num.length-2;i++){
            int j = i+1;
            int k = num.length-1;
            while(j<k){
                if(num[i]+num[j]+num[k]==0){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    ret.add((ArrayList<Integer>)list.clone());
                    while(j+1<k&&num[j+1]==num[j]) j++;
                    j++;
                    while(k-1>j&&num[k-1]==num[k]) k--;
                    k--;
                }
                else if(num[i]+num[j]+num[k]<0){
                    j++;
                }
                else if(num[i]+num[j]+num[k]>0){
                    k--;
                }
            }
            while(i+1<num.length-2&&num[i+1]==num[i]) i++;
        }
        return ret;
    }

    public static void main(String[] args){
        threesum t = new threesum();
        int[] num = {-2,0,1,1,2};
        t.threeSum(num);
    }
}
