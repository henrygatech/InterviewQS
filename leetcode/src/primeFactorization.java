import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/7.
 */
public class primeFactorization {

    public ArrayList<Integer> factor( int x) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 2; i <=x; i++) {
            while (x % i == 0) {
                ret.add(i);
                x /= i;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        primeFactorization p = new primeFactorization();
        ArrayList<Integer> ret = p.factor(15);
        for(int i = 0;i<ret.size();i++){
            System.out.println(ret.get(i));
        }
    }

}
