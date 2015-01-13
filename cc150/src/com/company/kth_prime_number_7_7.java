package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Henry on 2014/12/27.
 */
public class kth_prime_number_7_7 {
    /*
    Design an algorithm to find the kth number such that the only prime factors are
    3,5, and
    */

    public int findKth(int k){
        int count = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        int tmp = 1;
        q.offer(tmp);
        while(count<k){
            tmp = q.poll();
            q.offer(3*tmp);
            q.offer(5*tmp);
            q.offer(7*tmp);
            count++;
        }
        return tmp;
    }

    public static void main(String[] args){
        kth_prime_number_7_7 k = new kth_prime_number_7_7();
        System.out.println(k.findKth(10));
    }

}
