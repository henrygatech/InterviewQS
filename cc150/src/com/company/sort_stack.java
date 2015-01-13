package com.company;

import java.util.Stack;

/**
 * Created by Henry on 2014/12/26.
 */
public class sort_stack {

    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> buffer = new Stack<Integer>();

    public void sort(){
        if(s.isEmpty()){
            return;
        }
        while(!s.isEmpty()){
            int tmp = s.pop();
            if(buffer.isEmpty()){
                buffer.push(tmp);
            }
            else{
                while(!buffer.isEmpty()&&tmp<buffer.peek()){
                    s.push(buffer.pop());
                }
                buffer.push(tmp);
            }
        }

        s = buffer;

    }

    public static void main(String[] args){
        sort_stack s = new sort_stack();
        s.s.push(3);
        s.s.push(6);
        s.s.push(10);
        s.s.push(14);
        s.s.push(5);
        s.s.push(7);
        s.sort();
        while(!s.s.isEmpty()){
            System.out.println(s.s.pop());
        }
    }

}
