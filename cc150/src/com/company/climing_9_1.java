package com.company;

/**
 * Created by Henry on 2014/12/29.
 */
public class climing_9_1 {

    /*
    A child is running up a staircase with n steps, and can hop either 1 step, 2 steps,
    or 3 steps at a time. Implement a method to count how many possible ways the
    child can run up the stairs.
     */

    public int climb(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for(int i = 3;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        climing_9_1 c = new climing_9_1();
        System.out.println(c.climb(5));
    }

}
