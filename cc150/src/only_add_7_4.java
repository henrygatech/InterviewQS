import com.company.Main;

/**
 * Created by Henry on 2014/12/27.
 */
public class only_add_7_4 {
    public int subtract(int a, int b){
        return a+negate(b);
    }

    public int multiply(int x, int n){
        int ret = 0;
        if(n<0){
            while(n<0){
                ret+=x;
                n++;
            }
            ret = negate(ret);
        }
        else{
            while(n>0){
                ret+=x;
                n--;
            }
        }
        return ret;
    }

    public int divide(int x, int n){
        int count = 0;
        boolean isNeg = false;
        if(x<0&&n>0||x>0&&n<0){
            isNeg = true;
        }
        x = Math.abs(x);
        n = Math.abs(n);
        int sum = 0;
        while(sum<=x){
            sum+=n;
            if(sum<=x)
            count++;
        }
        return isNeg?negate(count):count;
    }

    public int negate(int x){
        int sum = 0;
        while(x!=0){
            int d = x<0?1:-1;
            sum = sum+d;
            x = x+d;
        }
        return sum;
    }


    public static void main(String[] args){
        only_add_7_4 o = new only_add_7_4();
        System.out.println(o.divide(-7, -2));
    }
}
