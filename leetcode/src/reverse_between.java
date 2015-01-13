import java.util.List;

/**
 * Created by Henry on 2014/11/30.
 */
public class reverse_between {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode revBefore = dummy;
        ListNode revAfter = dummy;
        ListNode revHead = dummy;
        ListNode revTail = dummy;
        int count = m-1;
        while(count>0){
            revBefore = revBefore.next;
            count--;
        }
        revHead = revBefore.next;
        count = n;
        while(count>0){
            revTail = revTail.next;
            count--;
        }

        if(revHead==revTail){
            return dummy.next;
        }

        revAfter = revTail.next;
        if(revHead.next==revTail){
            revTail.next = revHead;
            revBefore.next = revTail;
            revHead.next = revAfter;
            return dummy.next;
        }

        ListNode pre = revHead;
        ListNode nd = revHead.next;
        ListNode next = nd.next;
        while(pre!=revTail){
            nd.next = pre;
            pre = nd;
            nd = next;
            if(next!=null)
            next = next.next;
            else
                break;
        }

        revBefore.next = revTail;
        revHead.next = revAfter;
        return dummy.next;
    }

    public static void main(String[] args){
        reverse_between r = new reverse_between();
        ListNode t = new ListNode(1);
        t.next = new ListNode(2);
        t.next.next = new ListNode(3);

        r.reverseBetween(t,1,3);
    }
}
