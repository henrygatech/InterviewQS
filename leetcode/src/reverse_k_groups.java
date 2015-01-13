/**
 * Created by Henry on 2014/12/5.
 */
public class reverse_k_groups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode nd = dummy;
        ListNode cur = head;
        while(cur!=null){
            ListNode end = cur;
            int count = k-1;
            while(count>0){
                if(end.next==null){
                    nd.next = cur;
                    return dummy.next;
                }
                end = end.next;
                count--;
            }
            ListNode[] ret = reverse(cur,end);
            nd.next = ret[0];
            nd = ret[1];
            cur = nd.next;
        }
        return dummy.next;
    }

    public ListNode[] reverse(ListNode start, ListNode end){
        ListNode endNext = end.next;
        ListNode[] ret = new ListNode[2];
        if(start==end){
            ret[0] = start;
            ret[1] = end;
            return ret;
        }
        if(start.next == end){
            end.next = start;
            start.next = null;
            ret[0] = end;
            ret[1] = start;
            ret[1].next = endNext;
            return ret;
        }

        ListNode pre = null;
        ListNode cur = start;
        ListNode next = start.next;

        while(pre!=end){
            //if pre ==null, move along
            if(pre==null){
                next = next.next;
                pre = cur;
                cur = cur.next;
            }
            else{
                cur.next = pre;
                pre = cur;
                cur = next;
                if(next!=null)
                    next = next.next;
            }
        }
        ret[0] = end;
        ret[1] = start;
        ret[1].next = endNext;
        return ret;

    }

    public static void main(String[] args){
        reverse_k_groups r = new reverse_k_groups();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        r.reverseKGroup(l,2);
    }

}
