import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Henry on 2014/12/16.
 */

class Node{
    String key = null;
    String val = null;
    Node next = null;
    Node(String key,String val){
        this.key = key;
        this.val = val;
    }
}

public class HashTable {

    Node[] nodeTab;
    int cap = 0;

    public HashTable(int cap){
        this.nodeTab = new Node[cap];
        this.cap = cap;
    }

    public void put(String key, String val){
        int ind = hash(key);
        Node nd = null;
        for(nd = nodeTab[ind];nd!=null;nd = nd.next){
            if(nd.key.equals(key)){
                nd.val = val;
                return;
            }
        }
        Node dummy = new Node("","");
        dummy.next = nodeTab[ind];
        nd = dummy;
        while(nd.next!=null){
            nd = nd.next;
        }
        nd.next = new Node(key,val);
        nodeTab[ind] = dummy.next;
    }

    public String get(String key){
        int ind = hash(key);
        for(Node nd = nodeTab[ind];nd!=null;nd = nd.next){
            if(nd.key.equals(key)){
                return nd.val;
            }
        }
        return null;
    }

    public int hash(String str){
        int hash = 7;
        for(int i = 0;i<str.length();i++){
            hash = hash*31+str.charAt(i);
        }
        return hash%cap;
    }

    public static void main(String[] args){
        HashTable h = new HashTable(100);
        h.put("foo","bar");
        System.out.println(h.get("foo"));
    }
}
