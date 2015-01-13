import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Henry on 2015/1/6.
 */
public class median_of_stream {

    public int getMedian(int cur,int effectiveMedian,PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        if(cur<effectiveMedian){
            minHeap.offer(cur);
            while(minHeap.size()>maxHeap.size()+1){
                maxHeap.offer(minHeap.poll());
            }
        }
        else{
            maxHeap.offer(cur);
            while(maxHeap.size()>minHeap.size()+1){
                minHeap.offer(maxHeap.poll());
            }
        }
        if(maxHeap.size()<minHeap.size()){
            return minHeap.peek();
        }
        else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else {
            return (maxHeap.peek()+minHeap.peek())/2;
        }
    }

    public static void main(String[] args){
        median_of_stream m = new median_of_stream();
        int median = 0; // effective median
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        for(int i = 0; i < A.length; i++)
        {
            median = m.getMedian(A[i], median, minHeap, maxHeap);
            System.out.println(median);
        }
    }


}
