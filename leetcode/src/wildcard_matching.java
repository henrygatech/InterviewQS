/**
 * Created by Henry on 2014/11/20.
 */
public class wildcard_matching {

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m][n];

        //base cases
        for(int i = 0;i<m;i++){
            if(p.charAt(0)=='*'){
                dp[i][0] = true;
            }

            else if(i==0&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='?')){
                dp[i][0] = true;
            }
        }
        for(int i = 0;i<n;i++){
            if(s.charAt(0)=='*'){
                dp[0][i] = true;
            }
            else if(i==1&&p.charAt(1)=='*'){
                dp[0][1]=true;

            }
            else if(i==0&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='?')){
                dp[0][i] = true;
            }
        }

        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(p.charAt(j)!='*'){
                    if(dp[i-1][j-1]==true&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j))){
                        dp[i][j]=true;
                    }
                }
                else{
                    for(int k=0;k<=i;k++){
                        if(dp[k][j-1]==true){
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args){
        wildcard_matching w = new wildcard_matching();
        System.out.println(w.isMatch("a", "a*"));
    }



}
