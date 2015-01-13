package com.company;

import java.util.Stack;

/**
 * Created by Henry on 2014/12/25.
 */

class Tower{

    Stack<Integer> s;
    int index;

    public Tower(int ind){
        s  = new Stack<Integer>();
        this.index = ind;
    }
     public void moveDisk(int n, Tower target, Tower buffer){
         if(n<=0) return;
         moveDisk(n-1,buffer,target);
         moveTop(target);
         buffer.moveDisk(n - 1, target, this);
     }

    public void moveTop(Tower target){
        int tmp = s.pop();
        target.s.push(tmp);
        System.out.println("Move disk "+tmp+" from "+index+" to "+ target.index+" .");
    }

}


public class honai_tower_3_4 {
    public static void main(String[] args){
        honai_tower_3_4 h = new honai_tower_3_4();
        int n = 3;
        Tower[] towers = new Tower[3];
        for(int i = 0;i<3;i++){
            towers[i] = new Tower(i);
        }
        for(int i = n;i>0;i--){
            towers[0].s.push(i);
        }
        towers[0].moveDisk(3,towers[2],towers[1]);
    }


}
