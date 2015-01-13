import java.util.Arrays;

/**
 * Created by Henry on 2014/12/24.
 */
public class two_sum {

    public int[] twoSum(int[] numbers, int target) {
        int[] origin = (int[])numbers.clone();
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            if(numbers[left]+numbers[right]==target){
                int leftInd = -1;
                int rightInd = -1;
                for(int i = 0;i<origin.length;i++){
                    if(origin[i]==numbers[left]){
                        if(leftInd!=-1)
                        leftInd = i+1;
                    }
                    if(origin[i]==numbers[right]){
                        if(rightInd!=-1)
                        rightInd = i+1;
                    }
                }
                int[] ret = {Math.min(leftInd,rightInd),Math.max(leftInd,rightInd)};
                return ret;
            }
            else if(numbers[left]+numbers[right]<target){
                left++;
            }
            else{
                right--;
            }
        }
        int[] ret = {-1,-1};
        return ret;
    }

    public static void main(String[] args){
        two_sum t = new two_sum();
        int[] num = {0,4,3,0};
        t.twoSum(num,0);
    }
}
