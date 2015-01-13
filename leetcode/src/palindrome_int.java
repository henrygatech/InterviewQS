/**
 * Created by Henry on 2014/12/6.
 */
public class palindrome_int {

    public boolean isPalindrome(int x) {
        if(x<0){
            x = Math.abs(x);
        }

        int tmp = x;
        int sum = 0;
        while(tmp>0){
            int remain = tmp%10;
            sum = sum*10+remain;
            tmp = tmp/10;
        }

        return (sum==x);

    }

    public static void main(String[] args){
        palindrome_int p = new palindrome_int();
        p.isPalindrome(1);
    }
}
