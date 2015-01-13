import java.util.HashSet;

/**
 * Created by Henry on 2014/12/12.
 */
public class longest_consecutive_sequence {

    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(Integer i:num){
            set.add(i);
        }
        int max = 0;
        for(Integer i:num){
            //left
            int left = i;
            int right = i;
            while(set.contains(left-1)){
                left--;
            }
            while(set.contains(right+1)){
                right++;
            }
            max = Math.max(max,right-left+1);
        }

        return max;
    }

    public static void main(String[] args){
        longest_consecutive_sequence l  = new longest_consecutive_sequence();
        int[] num = {0};
        l.longestConsecutive(num);
    }
}
