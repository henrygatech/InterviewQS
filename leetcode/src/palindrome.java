/**
 * Created by Henry on 2014/11/17.
 */
public class palindrome {



    public boolean palindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0;i<n;i++){
            dp[i][i] = true;
        }
        for(int i = n-1;i>=0;i--){
            for(int j = i;j<n;j++){
                if(j-i<2&&s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                }
                else if(j-i>=2&&s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }

        return dp[0][s.length()-1];
    }

    public static void main(String[] args){
        palindrome p = new palindrome();
        System.out.println(p.palindrome("aba"));
    }

}
