/**
 * Created by Henry on 2014/12/5.
 */
public class divide {

    public int divide(int dividend, int divisor) {

        int count = 0;
        if(dividend==0){
            return 0;
        }
        boolean neg = false;

        if((divisor<0&&dividend>0)||(divisor>0&&dividend<0)){
            neg = true;

        }

        if(dividend==Integer.MIN_VALUE){
            count = 1;
            dividend += Math.abs(divisor);
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while(dividend>0){
            int ct = 0;
            int tmp = divisor;
            while(tmp<dividend){
                if((tmp<<1)>dividend||tmp<0)
                    break;
                else{
                    ct++;
                    tmp<<=1;
                }
            }
            dividend -= tmp;
            count+=1<<ct;
            if(dividend==0){
                return neg?-(count):(count);
            }
        }

        return neg?-(count-1):(count-1);
    }

    public static void main(String[] args){
        divide d = new divide();
        System.out.print(d.divide(-2147483648, 1));
    }
}
