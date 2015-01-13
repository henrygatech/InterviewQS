/**
 * Created by Henry on 2014/12/9.
 */
public class reorder_list {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode first = head;
        ListNode sec = slow.next;
        slow.next = null;
        sec = reverse(sec);
        ListNode ret = new ListNode(-1);
        ListNode nd = ret;
        while(first!=null&&sec!=null){
            nd.next = first;
            nd = nd.next;
            first = first.next;
            nd.next = sec;
            sec = sec.next;
            nd = nd.next;
        }
        if(first!=null){
            nd.next = first;
        }
        else if(sec!=null){
            nd.next = sec;
        }
        head = ret.next;
    }

    public ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        pre.next = null;
        while(cur!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            if(next!=null)
                next = next.next;
        }
        return pre;
    }

    public static void main(String[] args){
        reorder_list r = new reorder_list();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        r.reorderList(l);
    }

}
