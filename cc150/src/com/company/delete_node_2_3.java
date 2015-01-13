package com.company;

/**
 * Created by Henry on 2014/12/25.
 */


class ListNode{
    public int val;
    public ListNode next = null;
    public ListNode(int v){
        val = v;
    }
}
public class delete_node_2_3 {

    /*
    Implement an algorithm to delete a node in the middle of a singly linked list,
    given only access to that node.
    EXAMPLE
    Input: the node c from the linked list a->b->c->d->e
    Result: nothing is returned, but the new linked list looks like a- >b- >d->e
    */


    public ListNode delete(ListNode list){
        ListNode nd = list;
        if(nd.next==null){
            return list;
        }
        while(nd.next.next!=null){
            nd.val = nd.next.val;
            nd = nd.next;
        }
        nd.val = nd.next.val;
        nd.next = null;
        return list;
    }

    public static void main(String[] args){
        delete_node_2_3 d = new delete_node_2_3();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        ListNode list = d.delete(l.next);
        ListNode nd = list;
        while(nd!=null){
            System.out.println(nd.val);
            nd = nd.next;
        }
    }

}
