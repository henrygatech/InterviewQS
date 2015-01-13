/**
 * Created by Henry on 2014/12/6.
 */
public class longest_palindrom_substring {

    public boolean longestPalindrome(String s,int start, int end) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        String ret = "";
        //base cases:
        for(int i = 0;i<s.length();i++){
            dp[i][i] = true;
        }

        for(int i = s.length()-1;i>=0;i--){
            for(int j = i;j<s.length();j++){
                if(j-i<2&&s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                    if(j-i+1>max){
                        max = Math.max(max,j-i+1);
                        ret = s.substring(i,j+1);
                    }
                }
                else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if(j-i+1>max){
                        max = Math.max(max,j-i+1);
                        ret = s.substring(i,j+1);
                    }
                }
            }
        }

        return dp[start][end];
    }

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        String ret = "";
        //base cases:
        for(int i = 0;i<s.length();i++){
            dp[i][i] = true;
        }

        for(int i = s.length()-1;i>=0;i--){
            for(int j = i;j<s.length();j++){
                if(j-i<2&&s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                    if(j-i+1>max){
                        max = Math.max(max,j-i+1);
                        ret = s.substring(i,j+1);
                    }
                }
                else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];

                    if(dp[i][j]&&j-i+1>max){
                        max = Math.max(max,j-i+1);
                        ret = s.substring(i,j+1);
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args){
        longest_palindrom_substring l = new longest_palindrom_substring();
        //l.longestPalindrome("aaabaaaa");
        System.out.print(l.longestPalindrome("aaabaaaa", 0, 7));
    }
}
