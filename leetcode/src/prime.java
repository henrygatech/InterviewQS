import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/7.
 */
public class prime {

    public boolean isPrime(int x){

        int sq = (int)Math.sqrt(x+1);

        for(int i = 2;i<=sq;i++){
            if(x%i==0){
                return false;
            }
        }

        return true;
    }

    public ArrayList<Integer> primeUnder(int x){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        boolean[] notPrimes = new boolean[x+1];
        for(int i = 1;i<=x;i++){
            if(notPrimes[i]==true){
                continue;
            }
            else if(isPrime(i)==false){
                int count = 1;
                while(count*i<x){
                    notPrimes[count*i]=true;
                    count++;
                }
            }
        }

        for(int i = 1;i<=x;i++){
            if(notPrimes[i]==false)
            ret.add(i);
        }
        return ret;
    }

    public static void main(String[] args){
        prime p = new prime();
        ArrayList<Integer> ret = p.primeUnder(30);
        for(int i = 0;i<ret.size();i++){
            System.out.println(ret.get(i));
        }
    }

}
