import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Henry on 2014/12/2.
 */
public class add_one {
    public int[] reverse(int[] arr) {
        int[] ret = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            ret[arr.length-1-i] = arr[i];
        }

        return ret;
    }

    public int[] plusOne(int[] digits) {
        int[] one = {1};
        return plus(digits,one);
    }

    public int[] plus(int[] d1, int[] d2){

        d1 = reverse(d1);
        d2 = reverse(d2);
        int[] ret = new int[Math.max(d1.length,d2.length)+1];
        int carry = 0;
        int i = 0;
        for(i = 0;i<d2.length||i<d1.length;i++){
            if(i<d2.length&&i<d1.length) {
                int value = (d1[i] + d2[i] + carry) % 10;
                carry = (d1[i] + d2[i] + carry) / 10;
                ret[i] = value;
            }
            else if(i>=d1.length){
                int value = (d2[i]+carry)%10;
                carry = (d2[i]+carry)/10;
                ret[i] = value;
            }
            else if(i>=d2.length){
                int value = (d1[i]+carry)%10;
                carry = (d1[i]+carry)/10;
                ret[i] = value;
            }
        }
        if(carry>0){
            int value = (carry)%10;
            carry = (carry)/10;
            ret[i] = value;
        }
        else{
            ret = Arrays.copyOfRange(ret,0,ret.length-1);
        }
        ret = reverse(ret);
        return ret;
    }
    public static void main(String[] args){
        add_one a = new add_one();
        int[] num1 = {9,9,9,9};
        int[] num2 = {9,9,9,9};
        int[] ret = a.plus(num1,num2);
        for(int i = 0;i<ret.length;i++){
            System.out.println(ret[i]);
        }

    }


}
