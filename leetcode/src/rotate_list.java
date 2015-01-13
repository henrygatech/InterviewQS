/**
 * Created by Henry on 2014/12/2.
 */
public class rotate_list {
    public ListNode rotateRight(ListNode head, int n) {
        ListNode ret = head;
        while(n>0){
            ret = rotateOne(ret);
            n--;
        }
        return ret;
    }

    public ListNode rotateOne(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode nd = head;
        while(nd.next.next!=null){
            nd = nd.next;
        }
        ListNode tmp = nd.next;
        nd.next = null;
        tmp.next = head;
        return tmp;
    }

    public static void main(String[] args){
        rotate_list r = new rotate_list();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        r.rotateRight(l,2);
    }
}
