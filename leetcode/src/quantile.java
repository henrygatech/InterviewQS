import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Henry on 2015/1/4.
 */
public class quantile {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String input;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int size = 0;
        while((input=br.readLine())!=null){
            String[] strs = input.split(" ");
            map.put(Integer.parseInt(strs[0]),Integer.parseInt(strs[1]));
            size+=Integer.parseInt(strs[1]);
        }

        for(int i = 1;i<=Q-1;i++){
            //System.out.println(nums[(int)Math.ceil(size*i/Q)-1]);
            System.out.println(findKth(map,(int)Math.ceil(size*i/Q)-1));
        }
    }

    public static int findKth(HashMap<Integer,Integer> map,int k){
        Set<Integer> set  = map.keySet();
        int[] keys = new int[set.size()];
        int count = 0;
        for(Integer i:set){
            keys[count++] = i;
        }
        Arrays.sort(keys);
        for(int i = 0;i<keys.length;i++){
            if(k<0){
                return keys[i];
            }
            k-=map.get(keys[i]);
            if(k<0){
                return keys[i];
            }
        }
        return -1;
    }
}
