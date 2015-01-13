import java.util.List;

/**
 * Created by Henry on 2014/11/16.
 */

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
                val = x;
                next = null;
            }
     }

public class sort_list {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast.next!=null&&fast!=null){
            slow = slow.next;
            fast = fast.next.next;

        }
        ListNode sec = slow.next;
        slow.next = null;
        ListNode first = sortList(head);
        sec = sortList(sec);
        return merge(first,sec);
    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode nd = new ListNode(-1);
        ListNode head = nd;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                nd.next = new ListNode(l1.val);
                nd = nd.next;
                l1 = l1.next;
            }
            else{
                nd.next = new ListNode(l2.val);
                nd = nd.next;
                l2 = l2.next;
            }
        }

        while(l2!=null)//still l2 left
        {
            nd.next = new ListNode(l2.val);
            nd = nd.next;
            l2 = l2.next;
        }

        while(l1!=null)//still l1 left
        {
            nd.next = new ListNode(l1.val);
            nd = nd.next;
            l1 = l1.next;
        }

        return head.next;

    }

    public static void main(String[] args){
        sort_list s = new sort_list();
        ListNode n = new ListNode(2);
        n.next = new ListNode(1);
        s.sortList(n);
    }
}
