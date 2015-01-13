/**
 * Created by Henry on 2014/11/25.
 */
public class candy {
    public int candy(int[] ratings) {

        int[] dp = new int[ratings.length];

        for(int i = 0;i<ratings.length;i++){
            if(i==0){
                dp[i] = 1;
            }
            else{
                if(ratings[i]>ratings[i-1]){
                    dp[i] = dp[i-1]+1;
                }
                else{
                    dp[i] = 1;
                }
            }
        }

        int sum = 0;
        for(int i = ratings.length-1;i>=0;i--){
            if(i==ratings.length-1){
                sum+=dp[i];
            }
            else{
                if(ratings[i]>ratings[i+1]&&dp[i]<=dp[i+1]){
                    dp[i] = dp[i+1]+1;
                }
                sum+=dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args){

        candy c = new candy();
        int [] ratings = {4,2,3,4,1};
        System.out.print(c.candy(ratings));
    }
}
