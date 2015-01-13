/**
 * Created by Henry on 2014/12/9.
 */
public class insertion_sort_list {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode dm = dummy;
        ListNode nd = head;
        while(nd!=null){
            ListNode next = nd.next;
            insert(nd,dummy);
            nd = next;
        }
        return dummy.next;
    }

    public void insert(ListNode cur, ListNode dummy){
        ListNode nd = dummy;
        while(nd.next!=null){
            if(nd.next.val<cur.val){
                nd = nd.next;
            }
            else{
                cur.next = nd.next;
                nd.next = cur;
                return;
            }
        }
        nd.next = cur;
        cur.next = null;
    }

    public static void main(String[] args){
        insertion_sort_list i = new insertion_sort_list();
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        i.insertionSortList(l);
    }
}
