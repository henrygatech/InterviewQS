import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Henry on 2015/1/4.
 */
public class missing_number {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] nums = str.split(" ");
        int[] ints = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            ints[i] = Integer.parseInt(nums[i]);
        }
        HashMap<Integer, Integer> countmap = new HashMap<Integer, Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0;i<ints.length;i++){
            set.add(ints[i]);
            if(i<ints.length-1)
            countmap.put(ints[i+1]-ints[i],countmap.get(ints[i+1]-ints[i])==null?1:(countmap.get(ints[i+1]-ints[i])+1));
        }
        int maxkey = 0;
        int maxval = 0;
        for(int key:countmap.keySet()){
            if(countmap.get(key)>maxval){
                maxkey = key;
                maxval = countmap.get(key);
            }
        }
        int ret = -1;
        for(int i = 0;i<ints.length-1;i++){
            if((ints[i+1]-ints[i])!=maxkey) {
                ret = ints[i] + maxkey;
                break;
            }
        }
        System.out.println(ret);
    }

}
