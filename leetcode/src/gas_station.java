/**
 * Created by Henry on 2014/11/17.
 */
public class gas_station {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        //starting from i
        for(int i =0;i<n;i++){
            int count = 0;
            int j = i;
            int leftgas = 0;
            while(leftgas+gas[j]>=cost[j]){
                count++;
                if(count>=n)
                    return i;
                leftgas +=gas[j]-cost[j];
                if(leftgas<0) break;
                j = (++j)%n;

            }

            if(i<n-1&&leftgas+gas[j]<cost[j]) i = j;

        }
        return -1;
    }

    public static void main(String[] args){
        gas_station g = new gas_station();
        int[] gas = {2,4};
        int[] cost = {3,4};
        System.out.println(g.canCompleteCircuit(gas, cost));

    }
}
