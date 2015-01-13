/**
 * Created by Henry on 2015/1/6.
 */
public class bad_neibhors {

    /*
     经典的小偷问题：一排房子，每个房子里有一定价值的东西，小偷不能偷相邻的两个房间。
     即如果小偷光临了房间i, 那么就不能再偷房间i - 1和房间i + 1。
     要求返回小偷能偷到东西的总价值的最大值
     */

    public int maxValue(int[] house){
        int max = 0;
        int[] dp = new int[house.length];
        dp[0] = house[0];
        dp[1] = house[1];
        for(int i = 2;i<house.length;i++){
            dp[i] = Math.max(dp[i-2]+house[i],dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
