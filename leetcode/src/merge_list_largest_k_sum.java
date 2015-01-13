import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Henry on 2015/1/3.
 */

class MergeNode implements Comparable {
    int Aind;
    int Bind;
    int value;
    public MergeNode(int Ai, int Bi, int val){
        Aind = Ai;
        Bind = Bi;
        value = val;
    }

    @Override
    public int compareTo(Object o) {
        return (this.value-((MergeNode)o).value);
    }
}

public class merge_list_largest_k_sum{
    /*
    给A，B 2个array，里面都是integer，已经排好序了，由大到小，他们的长度都是N
    现在从A和B里各选出一个数，总成一个sum，请返回前N个最大的sum
    */

    public ArrayList<Integer> ksum(ArrayList<Integer> A,ArrayList<Integer> B){
        int N = A.size();
        int count = N;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        PriorityQueue<MergeNode> heap = new PriorityQueue<MergeNode>(10);
        heap.offer(new MergeNode(0,0,A.get(0)+B.get(0)));
        while(!heap.isEmpty()&&count>0) {
            MergeNode tmp = heap.poll();
            ret.add(tmp.value);
            if (tmp.Aind+1 < N) {
                heap.offer(new MergeNode(tmp.Aind + 1, tmp.Bind, A.get(tmp.Aind + 1) + B.get(tmp.Bind)));
            }
            if (tmp.Bind+1 < N) {
                heap.offer(new MergeNode(tmp.Aind, tmp.Bind + 1, A.get(tmp.Aind) + B.get(tmp.Bind + 1)));
            }
            count--;
        }
        return ret;
    }

    public static void main(String[] args){
        merge_list_largest_k_sum m = new merge_list_largest_k_sum();
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        A.add(3);
        A.add(2);
        A.add(1);
        B.add(3);
        B.add(2);
        B.add(1);
        ArrayList<Integer> ret =  m.ksum(A,B);
        for(int i = 0;i<ret.size();i++){
            System.out.println(ret.get(i));
        }
    }

}
