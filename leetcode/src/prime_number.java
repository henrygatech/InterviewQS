import java.util.ArrayList;

/**
 * Created by Henry on 2015/1/4.
 */
public class prime_number {

    public int numPrime(int n){
        n = n-1;
        int count = n;
        int mid = n/2;
        int[] nums = new int[n];
        for(int i = 1;i<=n;i++){
            nums[i-1] = i;
        }
        for(int i = 2;i<=mid;i++){
                for(int j = 2;j*i<=n;j++){
                    if(nums[j*i-1]!=-1)
                    {
                        nums[j*i-1] = -1;
                        count--;
                    }
                }
        }
        return count;

    }

    public boolean isPrime(int n){
        int mid = n/2;
        for(int i = 2;i<=mid;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        prime_number p = new prime_number();
        System.out.println(p.numPrime(11));
    }
}
