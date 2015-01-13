/**
 * Created by Henry on 2014/12/6.
 */
public class swap_node_in_pair {

    public ListNode swapPairs(ListNode head) {

        if(head==null)
            return null;

        if(!morethantwo(head)){
            return head;
        }

        ListNode next = head.next;
        ListNode after = next.next;
        next.next = head;
        head.next = swapPairs(after);

        return next;


    }

    public boolean morethantwo(ListNode head){
        ListNode nd = head;
        int count = 2;
        while(count>0){
            if(nd==null||nd.next==null)
                return false;
            count--;
            nd = nd.next;
        }
        return true;
    }

    public static void main(String[] args){
        swap_node_in_pair r = new swap_node_in_pair();
        ListNode t = new ListNode(1);
        t.next = new ListNode(2);

        r.swapPairs(t);
    }
}
