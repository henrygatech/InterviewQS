/**
 * Created by Henry on 2014/12/7.
 */
public class fibbonacci {
    public int[] fibo(int x){
        int[] dp = new int[x];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<x;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp;
    }

    public static void main(String[] args){
        fibbonacci f = new fibbonacci();
        int[] ret = f.fibo(100);
        for(int i = 0;i<ret.length;i++){
            System.out.println(ret[i]);
        }
    }

}
