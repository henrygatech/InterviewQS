/**
 * Created by Henry on 2014/12/29.
 */
public class magic_index_9_3 {
    /*
    A magic index in an array A[0.. .n-1] is defined to be an index such that A[i]
    = i. Given a sorted array of distinct integers, write a method to find a magic
    index, if one exists, in array A.
    */

    public int find(int[] A){
        int left = 0;
        int right = A.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(A[mid]==mid){
                return mid;
            }
            else if(A[mid]<mid){
                left = Math.max(mid+1,A[mid]);
            }
            else{
                right = Math.min(mid-1,A[mid]);
            }
        }

        return -1;
    }

    public static void main(String[] args){
        magic_index_9_3 m = new magic_index_9_3();
        //int[] A = {-3,-2,-1,1,3,5,6,9};
        int[] A =   {1,5,5,5,5,5,5,7};
        System.out.println(m.find(A));
    }

}
