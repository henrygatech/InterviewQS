/**
 * Created by Henry on 2014/12/13.
 */
public class distinct_subsequences {

    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] dp  = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i = 1;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i = 1;i<=S.length();i++){
            for(int j = 1;j<=T.length();j++){
                if(S.charAt(i)==T.charAt(j)){
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        distinct_subsequences d = new distinct_subsequences();
        d.numDistinct("b","b");
    }
}
