/**
 * Created by Henry on 2015/1/6.
 */
public class longest_palin {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        String ret = "";
        boolean[][] dp = new boolean[len][len];
        for(int i = len-1;i>=0;i--){
            for(int j = i;j<len;j++){
                if(i==j) {
                    dp[i][j] = true;
                    if((j-i+1)>maxLen){
                        maxLen = j-i+1;
                        ret = s.substring(i,j+1);
                    }
                }
                else if(j-i<2&&s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                    if((j-i+1)>maxLen){
                        maxLen = j-i+1;
                        ret = s.substring(i,j+1);
                    }
                }
                else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if(dp[i][j]==true&&(j-i+1)>maxLen){
                        maxLen = j-i+1;
                        ret = s.substring(i,j+1);
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args){
        longest_palin l = new longest_palin();
        System.out.println(l.longestPalindrome("a"));
    }
}
