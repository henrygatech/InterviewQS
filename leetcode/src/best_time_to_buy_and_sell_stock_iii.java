/**
 * Created by Henry on 2014/12/12.
 */
public class best_time_to_buy_and_sell_stock_iii {

    public int maxProfit(int[] prices) {
        if(prices.length==0||prices.length==1){
            return 0;
        }

        int m = prices.length;
        int min = Integer.MAX_VALUE;
        int maxprofit = 0;
        int[] before = new int[m];
        //before[i] including i
        min = prices[0];
        before[0] = 0;
        for(int i = 1;i<prices.length;i++){
            maxprofit = Math.max(maxprofit,prices[i]-min);
            before[i] = maxprofit;
            min = Math.min(prices[i],min);
        }

        int max = prices[m-1];
        maxprofit = 0;
        //after  including i
        int[] after = new int[m];
        after[m-1] = 0;
        for(int i=m-2;i>=0;i--){
            maxprofit = Math.max(maxprofit,max-prices[i]);
            after[i] = maxprofit;
            max = Math.max(prices[i],max);
        }

        int ret = 0;
        for(int i = 0;i<m;i++){
            if(i+1<m){
                ret = Math.max(ret,before[i]+after[i+1]);
            }
            else{
                ret = Math.max(ret,before[i]);
            }
        }

        return ret;

    }

    public static void main(String[] args){
        best_time_to_buy_and_sell_stock_iii best = new best_time_to_buy_and_sell_stock_iii();
        int[] num = {1,2,4};
        best.maxProfit(num);
    }
}
