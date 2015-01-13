package com.company;

import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/27.
 */
public class gen_primes {
    public boolean isPrime(int x){
        if(x==1)
            return true;
        for(int i = 2;i<=Math.sqrt(x);i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> genPrimes(int x){
        int[] ret = new int[x];
        for(int i = 0;i<x;i++){
            ret[i] = i+1;
        }
        for(int i = 2;i<x;i++){
            if(isPrime(i)){
                int count = 2;
                while(count*i<=x){
                    ret[i*count-1] = 0;
                    count++;
                }
            }
        }
        ArrayList<Integer> newret = new ArrayList<Integer>();
        for(int i = 0;i<x;i++){
            if(ret[i]!=0){
                newret.add(ret[i]);
            }
        }
        return newret;
    }

    public static void main(String[] args){
        gen_primes g = new gen_primes();
        //System.out.println(g.isPrime(4));
        ArrayList<Integer> ret = g.genPrimes(100);
        for(int i = 0;i<ret.size();i++){
            System.out.println(ret.get(i));
        }


    }
}
