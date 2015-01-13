import java.util.List;

/**
 * Created by Henry on 2014/12/23.
 */
public class reverse_groups {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        if(length(head)<k){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        for(int i = 1;i<k;i++){
            cur.next = pre;
            pre = cur;
            cur = next;
            if(next!=null)
                next = next.next;
        }
        head.next = reverseKGroup(cur,k);
        return cur;
    }

    public int length(ListNode head){
        ListNode nd = head;
        int count = 0;
        while(nd!=null){
            count++;
            nd = nd.next;
        }
        return count;
    }

    public static void main(String[] args){
        reverse_groups r = new reverse_groups();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        r.reverseKGroup(list,1);
    }
}
