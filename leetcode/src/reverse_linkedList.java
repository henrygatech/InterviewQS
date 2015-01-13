import java.util.List;

/**
 * Created by Henry on 2014/11/22.
 */

public class reverse_linkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n==m)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode before = dummy;
        ListNode after = dummy;
        int count = n-m+2;
        while(count>0){
            after = after.next;
        }
        while(n>1){
            before = before.next;
            after = after.next;
        }
        if(n-m<2){
            ListNode pre = before.next;
            ListNode end = before.next.next;
            end.next = pre;
            pre.next = after;
            before.next = end;
            return dummy.next;
        }

        ListNode pre = before.next;
        ListNode start = pre;
        ListNode cur = pre.next;
        ListNode next = cur.next;
        pre.next = null;
        while(cur!=after){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        before.next = pre;
        start.next = after;
        return dummy.next;
    }

    public static void main(String[] args){
        reverse_linkedList r = new reverse_linkedList();
        ListNode l = new ListNode(3);
        l.next = new ListNode(5);
        ListNode ret =  r.reverseBetween(l,1, 2);
        //ListNode ret = r.reverse(l,l.next.next);
        while(ret!=null){
            System.out.print(ret.val);
            ret = ret.next;
        }
    }

}
