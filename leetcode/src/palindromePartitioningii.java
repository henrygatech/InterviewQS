/**
 * Created by Henry on 2014/11/17.
 */
public class palindromePartitioningii {

    public int minCut(String s) {
        int ret = Integer.MAX_VALUE;
        int m = s.length();
        boolean[][] palin = new boolean[s.length()][s.length()];
        for(int i = m-1;i>=0;i--){
            for(int j = i;j<m;j++){
                if(s.charAt(i)==s.charAt(j)&&j-i>2){
                    palin[i][j] = palin[i+1][j-1];
                }
                else if(j-i<=2&&s.charAt(i)==s.charAt(j)){
                    palin[i][j] = true;
                }
            }
        }

        int[] dp = new int[s.length()];
        dp[0] = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(!palin[0][i]){
                int min = Integer.MAX_VALUE;
                for(int j = 0;j<i;j++){
                    if(palin[j+1][i]){
                        min = Math.min(min,dp[j]);
                    }
                }
                dp[i] = min+1;
            }
        }

        return dp[m-1];
    }

    public static void main(String[] args){
        palindromePartitioningii p = new palindromePartitioningii();
        System.out.println(p.minCut("efe"));

    }
}
