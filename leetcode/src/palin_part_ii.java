/**
 * Created by Henry on 2014/11/26.
 */
public class palin_part_ii {

    public int minCut(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0;i<n;i++){
            dp[i][i] = true;
        }

        for(int i = n-1;i>=0;i--){
            for(int j = i;j<n;j++){
                if(j-i<2&&str.charAt(i)==str.charAt(j)){
                    dp[i][j] = true;
                }
                else if(str.charAt(i)==str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }

        int[] d = new int[n];

        for(int i=n-1;i>=0;i--){
            if(i==n-1)
            {
                d[i] = 0;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j = i+1;j<n;j++){
                if(dp[i][j-1]==true){
                    min = Math.min(d[j]+1,min);
                }
                else{
                    continue;
                }
            }

            d[i] = min;
        }

        return d[0];
    }

    public static void main(String[] args){
        palin_part_ii p = new palin_part_ii();
        System.out.println(p.minCut("leet"));

    }
}
