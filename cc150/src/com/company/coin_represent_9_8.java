package com.company;

/**
 * Created by Henry on 2014/12/29.
 */
public class coin_represent_9_8 {

    int[] s = {1,5,10,25};
    public int makeChange(int n,int m){
        if(s[m]==1){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(n==0)
            return 1;
        return makeChange(n-s[m],m)+makeChange(n,m-1);
    }

    public static void main(String[] args){
        coin_represent_9_8 c = new coin_represent_9_8();
        System.out.println(c.makeChange(100, 3));
    }

}
