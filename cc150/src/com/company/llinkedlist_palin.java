package com.company;

import java.util.Stack;

/**
 * Created by Henry on 2014/12/25.
 */
public class llinkedlist_palin {

    public boolean isPalin(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> s = new Stack<Integer>();
        s.push(slow.val);
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            s.push(slow.val);
        }

        if(fast==null){
            //just equal
            while(slow!=null){
                if(slow.val==s.peek()){
                    s.pop();
                    slow = slow.next;
                }
                else return false;
            }
        }
        else{
            // stack more than rest
            s.pop();
            slow = slow.next;
            while(slow!=null){
                if(slow.val==s.peek()){
                    s.pop();
                    slow = slow.next;
                }
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        llinkedlist_palin l = new llinkedlist_palin();
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next  = new ListNode(3);
        System.out.println(l.isPalin(n));
    }


}
