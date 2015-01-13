/**
 * Created by Henry on 2014/11/25.
 */
public class gas_stations {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int m = gas.length;
        for(int i = 0;i<gas.length;i++){
            int remains = 0;
            int count = 0;
            int ind = i;
            while(remains+gas[ind]>=cost[ind]){
                remains+=gas[ind]-cost[ind];
                remains = Math.max(0,remains);
                if(count==m)
                    return i;
                count++;
                ind = (++ind)%(m);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        gas_stations g = new gas_stations();
        int[] gas = {2,4};
        int[] cost = {3,4};
        System.out.println(g.canCompleteCircuit(gas, cost));

    }
}
