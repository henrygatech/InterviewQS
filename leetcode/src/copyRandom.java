import java.util.HashMap;

/**
 * Created by Henry on 2014/12/30.
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class copyRandom {

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode nd = head;
        while(nd!=null){
            map.put(nd,new RandomListNode(nd.label));
            nd = nd.next;
        }
        nd = head;
        while(nd!=null){
            map.get(nd).next = map.get(nd.next);
            map.get(nd).random = map.get(nd.random);
            nd = nd.next;
        }
        return map.get(head);
    }

    public static void main(String[] args){
        copyRandom c = new copyRandom();
        RandomListNode n = new RandomListNode(-1);
        n.next = new RandomListNode(-1);
        RandomListNode ret = c.copyRandomList(n);


    }
}
