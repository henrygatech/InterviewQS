/**
 * Created by Henry on 2014/12/4.
 */
public class linkedin {
    /*
    Question 1:
    Given a 2D array of Integers, Design and Code an algorithm that will help a service / function get the sum of the sub-section [ (x1,y1), (x2,y2) ].
    Optimize with an assumption that this service will be called for the SAME array everytime, but will be called very frequently.
    > M * N
    1 2 3 4
    1 2 3 4
    1 2 3 4
    (0,0);(2,3) = 30
    (0,0);(1,1) = 6
    (1,1);(2,2) = 10
    */

    public int m = 3, n = 4;
    public int[][] A = {{1,2,3,4},{1,2,3,4},{1,2,3,4}};
    public int sumRectangle(int x1, int x2, int y1, int y2){

        int[][] dp = new int[m+1][n+1];

        dp[1][1] = A[0][0];
        for(int i = 2;i<=n;i++){
            dp[1][i] = dp[1][i-1]+A[1-1][i-1];
        }

        for(int i = 2;i<=m;i++){
            dp[i][1] = dp[i-1][1]+A[i-1][1-1];
        }

        for(int i = 2;i<=m;i++){
            for(int j = 2;j<=n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] -dp[i-1][j-1] +A[i-1][j-1];
            }
        }

        return dp[x2+1][y2+1] - dp[x2][y1] -dp[x1][y2] +dp[x1][y1];
    }

    public static void  main(String[] args){
        linkedin l = new linkedin();
        System.out.println(l.sumRectangle(1,2,1,2));
    }
}
