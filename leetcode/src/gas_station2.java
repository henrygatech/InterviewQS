/**
 * Created by Henry on 2014/12/11.
 */
public class gas_station2 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for(int i = 0;i<n;i++){
            //start from i
            int count = n;
            int remains = 0;
            int j = i;
            while(count>0){
                if(gas[j]+remains<cost[j]){
                    break;
                }
                else{
                    remains = gas[j]+remains-cost[j];
                    j = (j+1)%n;
                    count--;
                }
            }
            if(count==0){
                return i;
            }
            else{
                i = j;
                continue;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        gas_station2 g = new gas_station2();
        int[] gas = {4};
        int[] cost = {5};
        System.out.println(g.canCompleteCircuit(gas, cost));

    }
}
