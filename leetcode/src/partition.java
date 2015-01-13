/**
 * Created by Henry on 2014/12/15.
 */
public class partition {
    public ListNode partition(ListNode head, int x) {
        ListNode lessdummy = new ListNode(-1);
        ListNode less = lessdummy;
        ListNode greaterdummy = new ListNode(-1);
        ListNode greater = greaterdummy;
        ListNode nd = head;
        while(nd!=null){
            if(nd.val<x){
                less.next = nd;
                less = less.next;
            }
            else{
                greater.next = nd;
                greater = greater.next;
            }
            nd = nd.next;
        }
        less.next = greaterdummy.next;
        return lessdummy.next;
    }

    public static void main(String[] args){
        partition p = new partition();
        ListNode l = new ListNode(2);
        l.next = new ListNode(1);

        p.partition(l,2);
    }
}
