/**
 * Created by Henry on 2014/11/16.
 */
public class insertion_sort {

    public ListNode insertionSortList(ListNode head) {
        if(head ==null){
            return head;
        }
        if(head.next==null){
            return head;
        }

        //create the dummy node
        ListNode nd = new ListNode(-1);
        nd.next = head;
        head = nd;
        ListNode n = head;
        ListNode cur = head;
        boolean flag = false;
        while(cur.next!=null){
            while(n.next!=null&&n.next.val<=cur.next.val){
                if(n.next==cur.next) {
                    flag = true;
                    break;
                }
                n = n.next;

            }

            if(flag==true){
                n = head;
                cur = cur.next;
                flag =false;
                continue;
            }
            if(n.next!=null&&n.next.val>cur.next.val){
                //remove the cur.next from
                ListNode tmp = cur.next;
                cur.next = cur.next.next;
                tmp.next = n.next;
                n.next = tmp;
                n = head;
            }
            else{
                n = head;
                cur = cur.next;
            }

        }

        return head.next;

    }
    public static void main(String[] args){
        insertion_sort i = new insertion_sort();
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
