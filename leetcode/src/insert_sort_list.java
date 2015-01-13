/**
 * Created by Henry on 2014/11/24.
 */
public class insert_sort_list {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode n = dummy;
        while(n.next!=null){
            ListNode next = n.next;
            ListNode tmp = new ListNode(n.next.val);
            n.next = n.next.next;
            insert(dummy,tmp);
            n = next;
        }
        return dummy.next;
    }

    public void insert(ListNode dummy, ListNode tmp){

        ListNode n = dummy;
        while(n.next!=null){
            if(tmp.val<n.next.val){
                tmp.next = n.next;
                n.next = tmp;
                return ;
            }
            n = n.next;
        }
        n.next = tmp;

    }

    public static void main(String[] args){
        insert_sort_list i = new insert_sort_list();
        ListNode n = new ListNode(3);
        n.next = new ListNode(4);
        n.next.next = new ListNode(1);
        ListNode l = i.insertionSortList(n);
        while(l!=null){
            System.out.println(l.val);
            l = l.next;
        }
    }

}
