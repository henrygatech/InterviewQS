/**
 * Created by Henry on 2014/11/25.
 */
public class palindrome_part {

    public boolean palindrome(String s,int indi,int indj) {
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
                else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }

        return dp[indi][indj];

    }

    public static void main(String[] args){
        palindrome_part p = new palindrome_part();
        System.out.println(p.palindrome("aba",0,2));
    }

}
